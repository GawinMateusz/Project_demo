package com.sda.diary.frontend;

import com.sda.diary.entry.EntryController;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class UserInterface {

    private final EntryController entryController;

    public void run(){
        System.out.println("Aplikacja jest uruchomiona\n");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Witaj w elektronicznym dzienniku, co chcesz zrobić?");
            System.out.println("1. Dodaj nowy wpis");
            System.out.println("2. Wyśtwietlić wszystkie wpisy");
            System.out.println("0. Zamknąć aplikację");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    createEntry();
                    break;
                case 2:
                    getAllEntries();
                    break;
                case 0:
                    return;
            }
        }
    }

    private void getAllEntries() {
        // GET: /entry do serwera
        String entries = entryController.getAllEntries();
        System.out.println("Odpowiedź serwera: " + entries);
    }

    private void createEntry() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj tytuł wpisu: ");
        String title = scanner.nextLine();
        System.out.println("Podaj zawartość wpisu: ");
        String content = scanner.nextLine();
        String requestBody = String.format("{\"title\":\"%s\",\"content\":\"%s\"}", title, content);
        String responseBody = entryController.createEntry(requestBody);
        System.out.println("Odpowiedź serwera: " + responseBody);


    }
}
