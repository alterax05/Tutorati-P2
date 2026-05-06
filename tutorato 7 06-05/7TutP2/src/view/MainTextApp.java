package view;

import model.Giocatore;
import model.bros.BroIntf;
import model.bros.EliteBro;
import model.broslist.BrosList;
import model.exceptions.*;
import model.gradi.Rank_Enms;
import model.partita.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MainTextApp {
    private final Scanner scanner = new Scanner(System.in);
    private Giocatore player;
    private BrosList brosList;
    private PartitaIntf partita;

    public MainTextApp() {
        player = new Giocatore();
        brosList = new BrosList();
        partita = new PartitaGold();
    }

    public void start() {
        while (true) {
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

    private void showMainMenu() {
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

    private void startMatch(Rank_Enms rank) {
        switch (rank) {
            case Gold -> partita = new PartitaGold();
            case Diamond -> partita = new PartitaDiamond();
            case Master -> partita = new PartitaMasters();
            default -> throw new IllegalArgumentException("Rank non supportato: " + rank);
        }

        System.out.println("\n=== PARTITA " + rank + " ===\n");

        // Handle banning phase (if applicable)
        if (partita.getStage() == Partita_stages.Banning) {
            handleBanningPhase();
        }

        // Handle character selection
        handleSelectionPhase();

        // Handle match outcome
        handleMatchResult();
    }

    private void handleBanningPhase() {
        System.out.println("L'avversario banna 2 personaggi:\n");
        
        while (partita.getStage() == Partita_stages.Banning) {
            displayCharacterList();
            String input = scanner.nextLine().trim();
            
            try {
                int choice = Integer.parseInt(input) - 1;
                if (choice < 0 || choice >= brosList.getBroslist().size()) {
                    System.out.println("Personaggio non trovato!");
                    continue;
                }
                
                BroIntf bro = brosList.getBroslist().get(choice);
                
                // Check if already banned
                if (partita.isBanned(bro)) {
                    System.out.println("Errore: Il personaggio è già stato bannato!\n");
                    continue;
                }
                
                partita.addBan(bro);
                System.out.println(bro.toString() + " è stato bannato!\n");
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un numero valido!\n");
            }
            catch (CannotBanException e) {
                System.out.println("Non è possibile bannare questo bro\n");
            }
            catch (CannotBanAgainException e) {
                System.out.println("Non è possibile bannare di nuovo questo bro\n");
            }
        }
    }

    private void handleSelectionPhase() {
        System.out.println("Selezionare 2 personaggi:\n");
        
        while (partita.getStage() == Partita_stages.Selecting) {
            displayCharacterList();
            String input = scanner.nextLine().trim();
            
            try {
                int choice = Integer.parseInt(input) - 1;
                if (choice < 0 || choice >= brosList.getBroslist().size()) {
                    System.out.println("Personaggio non trovato!");
                    continue;
                }
                
                BroIntf bro = brosList.getBroslist().get(choice);
                
                // Check if banned
                if (partita.isBanned(bro)) {
                    System.out.println("Errore: Il personaggio è bannato!\n");
                    continue;
                }
                
                partita.addBro(bro);
                System.out.println(bro.toString() + " [SELEZIONATO]\n");
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un numero valido!\n");
            } catch (AlreadyAddedException e) {
                System.out.println("Errore: Bro già inserito\n");
            } catch (BroNonPermessoException e) {
                System.out.println("Errore: Non è possibile selezionare il bro\n");
            } catch (MaxSelectReachedException e) {
                System.out.println("Errore: Num massimo di bro raggiunto\n");
            } catch (AlreadyBannedException e) {
                System.out.println("Errore: Bro bannato");
            }
        }
    }

    private void displayCharacterList() {
        ArrayList<BroIntf> bros = brosList.getBroslist();
        
        for (int i = 0; i < bros.size(); i++) {
            BroIntf bro = bros.get(i);
            System.out.print((i + 1) + ". " + bro.toString());

            // Display Banned tag
            if (partita.isBanned(bro)) {
                System.out.print(" [BANNATO]");
            }
            
            // Display Selected tag
            if (partita.isSelected(bro)) {
                System.out.print(" [SELEZIONATO]");
            }
            
            System.out.println();
        }
        
        String prompt = partita.getStage() == Partita_stages.Banning ? "Bannare" : "Giocatore";
        System.out.print(prompt + ": ");
    }

    private void handleMatchResult() {
        System.out.println("\nVinci o perdi:");
        System.out.print("(v/p): ");
        String outcome = scanner.nextLine().trim().toLowerCase();
        
        if (!outcome.equals("v") && !outcome.equals("p")) {
            System.out.println("Inserisci 'v' o 'p'!\n");
            handleMatchResult();
            return;
        }

        boolean victory = outcome.equals("v");
        
        try {
            // Only add XP if the player wins
            if (victory) {
                partita.play(player);
            }

            System.out.println(partita);
            
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}
