package org.example.hellomaven;

import java.util.Scanner;

public class JukeboxImplementation {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Operations opr=new Operations();

        while(true)
        {
            System.out.println("Welcome to jukebox");
            System.out.println("Select \n1 for viewing existing playlists\n2 to create playlist\n3 to view all songs\n4 to view all podcasts\n5 to exit");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
                case 1: opr.viewPlaylist();break;
                case 2: opr.createPlaylist();break;
                case 3: opr.viewAllSongs();break;
                case 4: opr.viewAllPodcasts();break;
                case 5: return;
                default:
                    System.out.println("Enter valid input");

            }
        }
    }
}
