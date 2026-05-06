package view;

import model.Giocatore;
import model.bros.BroIntf;
import model.bros.EliteBro;
import model.broslist.BrosList;
import model.gradi.Rank_Enms;
import model.partita.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainTextApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static Giocatore player;
    private static BrosList brosList;
    
    // Track selected and banned characters for display purposes
    private static Set<BroIntf> selectedBros;
    private static Set<BroIntf> bannedBros;

    public static void main(String[] args) {
        initializeGame();
        mainLoop();
    }

    private static void initializeGame() {
        // Initialize player with default starting stats (1,000,000 XP, Gold Expert)
        player = new Giocatore();
        
        // Initialize the character roster with 6 default characters
        brosList = new BrosList();
    }

    private static void mainLoop() {
        boolean running = true;
        while (running) {
            showMainMenu();
            String input = scanner.nextLine().trim();
            
            if (input.isEmpty()) {
                continue;
            }

            switch (input) {
                case "1" -> startMatch(Rank_Enms.Gold);
                case "2" -> {
                    if (player.canPlay(Rank_Enms.Diamond)) {
                        startMatch(Rank_Enms.Diamond);
                    } else {
                        System.out.println("Non puoi giocare a questo livello!");
                    }
                }
                case "3" -> {
                    if (player.canPlay(Rank_Enms.Master)) {
                        startMatch(Rank_Enms.Master);
                    } else {
                        System.out.println("Non puoi giocare a questo livello!");
                    }
                }
                default -> System.out.println("Scelta non valida!");
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("\nGiocatore: " + player.toString());
        System.out.println("Selezionare un livello con cui procedere:");
        System.out.println("1. GOLD");
        
        if (player.canPlay(Rank_Enms.Diamond)) {
            System.out.println("2. DIAMOND");
        }
        
        if (player.canPlay(Rank_Enms.Master)) {
            System.out.println("3. MASTER");
        }
        
        System.out.print("Livello: ");
    }

    private static void startMatch(Rank_Enms rank) {
        PartitaIntf partita;
        selectedBros = new HashSet<>();
        bannedBros = new HashSet<>();
        
        switch (rank) {
            case Gold -> partita = new PartitaGold();
            case Diamond -> partita = new PartitaDiamond();
            case Master -> partita = new PartitaMasters();
            default -> throw new IllegalArgumentException("Rank non supportato: " + rank);
        }

        System.out.println("\n=== PARTITA " + rank + " ===\n");

        // Handle banning phase (if applicable)
        if (partita.getStage() == Partita_stages.Banning) {
            handleBanningPhase(partita, rank);
        }

        // Handle character selection
        handleSelectionPhase(partita, rank);

        // Handle match outcome
        handleMatchResult(partita, rank);
    }

    private static void handleBanningPhase(PartitaIntf partita, Rank_Enms rank) {
        System.out.println("L'avversario banna 2 personaggi:\n");
        
        while (partita.getStage() == Partita_stages.Banning) {
            displayCharacterList(Partita_stages.Banning, rank);
            String input = scanner.nextLine().trim();
            
            try {
                int choice = Integer.parseInt(input) - 1;
                if (choice < 0 || choice >= brosList.getBroslist().size()) {
                    System.out.println("Personaggio non trovato!");
                    continue;
                }
                
                BroIntf bro = brosList.getBroslist().get(choice);
                
                // Check if already banned
                if (bannedBros.contains(bro)) {
                    System.out.println("Errore: Il personaggio è già stato bannato!\n");
                    continue;
                }
                
                partita.addBan(bro);
                bannedBros.add(bro);
                System.out.println(bro.toString() + " è stato bannato!\n");
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un numero valido!\n");
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage() + "\n");
            }
        }
    }

    private static void handleSelectionPhase(PartitaIntf partita, Rank_Enms rank) {
        System.out.println("Selezionare 2 personaggi:\n");
        
        while (partita.getStage() == Partita_stages.Selecting) {
            displayCharacterList(Partita_stages.Selecting, rank);
            String input = scanner.nextLine().trim();
            
            try {
                int choice = Integer.parseInt(input) - 1;
                if (choice < 0 || choice >= brosList.getBroslist().size()) {
                    System.out.println("Personaggio non trovato!");
                    continue;
                }
                
                BroIntf bro = brosList.getBroslist().get(choice);
                
                // Check if banned
                if (bannedBros.contains(bro)) {
                    System.out.println("Errore: Il personaggio è bannato!\n");
                    continue;
                }
                
                // For Masters, check if character is allowed
                if (rank == Rank_Enms.Master && !bro.isPossibile()) {
                    System.out.println("Errore: Questo personaggio non è disponibile in questa categoria!\n");
                    continue;
                }
                
                // For Diamond and Master, prevent duplicate selections
                // For Gold, allow duplicate selections
                if (rank != Rank_Enms.Gold && selectedBros.contains(bro)) {
                    System.out.println("Errore: Il personaggio è già stato selezionato!\n");
                    continue;
                }
                
                partita.addBro(bro);
                selectedBros.add(bro);
                System.out.println(bro.toString() + " [SELEZIONATO]\n");
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un numero valido!\n");
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage() + "\n");
            }
        }
    }

    private static void displayCharacterList(Partita_stages stage, Rank_Enms rank) {
        ArrayList<BroIntf> bros = brosList.getBroslist();
        
        for (int i = 0; i < bros.size(); i++) {
            BroIntf bro = bros.get(i);
            System.out.print((i + 1) + ". " + bro.toString());

            // Display Banned tag
            if (bannedBros.contains(bro)) {
                System.out.print(" [BANNATO]");
            }
            
            // Display Selected tag
            if (selectedBros.contains(bro)) {
                System.out.print(" [SELEZIONATO]");
            }
            
            System.out.println();
        }
        
        String prompt = stage == Partita_stages.Banning ? "Bannare" : "Giocatore";
        System.out.print(prompt + ": ");
    }

    private static void handleMatchResult(PartitaIntf partita, Rank_Enms rank) {
        System.out.println("\nVinci o perdi:");
        System.out.print("(v/p): ");
        String outcome = scanner.nextLine().trim().toLowerCase();
        
        if (!outcome.equals("v") && !outcome.equals("p")) {
            System.out.println("Inserisci 'v' o 'p'!\n");
            handleMatchResult(partita, rank);
            return;
        }

        boolean victory = outcome.equals("v");
        
        try {
            // Only add XP if the player wins
            if (victory) {
                partita.play(player);
            }
            
            // Display match result
            System.out.println("\nHai " + (victory ? "Vinto" : "Perso") + ".");
            System.out.println("Partita di livello: " + rank);
            
            // Display selected characters
            System.out.print("Personaggi selezionati: ");
            selectedBros.forEach(b -> System.out.print(b.toString() + " "));
            System.out.println();
            
            // Display banned characters
            if (!bannedBros.isEmpty()) {
                System.out.print("Personaggi bannati: ");
                bannedBros.forEach(b -> System.out.print(b.toString() + " "));
                System.out.println();
            }
            
            // Display total XP
            System.out.println("Punti totalizzati: " + player.toString());
            
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
