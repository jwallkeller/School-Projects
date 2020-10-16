package keller_project1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Jack Keller
 */
public class Media implements Serializable {

    private String title;
    private String format;
    private boolean loaned;
    private String date;
    private String loanee;

    public Media(String title, String format) {
        this.title = title;
        this.format = format;
        this.loaned = false;

    }

    public String getTitle() {
        return title;
    }

    public void loan(String date, String loanee) {
        this.loaned = true;
        this.date = date;
        this.loanee = loanee;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.title);
        hash = 71 * hash + Objects.hashCode(this.format);
        hash = 71 * hash + (this.loaned ? 1 : 0);
        hash = 71 * hash + Objects.hashCode(this.date);
        hash = 71 * hash + Objects.hashCode(this.loanee);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Media other = (Media) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }

    public void loanReturn() {
        this.loaned = false;
        this.date = "";
    }

    @Override
    public String toString() {
        if (loaned) {
            return "\n" + "Title: " + title + "\n" + "Format: " + format + "\n" + "Loaned to: " + loanee + "\n" + "Date Loaned: " + date;
        } else {
            return "\n" + "Title: " + title + "\n" + "Format: " + format;
        }
    }

    public static Comparator<Media> MediaTitleComparator = new Comparator<Media>() {

        public int compare(Media m1, Media m2) {
            String MediaTitle1 = m1.getTitle().toUpperCase();
            String MediaTitle2 = m2.getTitle().toUpperCase();

            return MediaTitle1.compareTo(MediaTitle2);
        }
    };
    
    // This function takes the library and the choice (either 1 or 5) and checks
    // the library for the specified media. It then either adds or removes the 
    // media.

    public ArrayList<Media> editLibrary(ArrayList<Media> library, int choice) {
        if (choice == 1) {
            for (Media m : library) {
                if (title.compareTo(m.getTitle()) == 0) {
                    System.out.println("\nThat media is already in the library.");
                    return library;
                }
            }
            
            library.add(this);

            System.out.println("The media was added to the library.");

            return library;
        } else if (choice == 5) {
            for (Media m : library) {
                if (title.compareTo(m.getTitle()) == 0) {
                    library.remove(m);
                    System.out.println("\nThe media was removed from the library");
                    return library;
                }
                
                System.out.println("\nThat media was not found in the library.");
                
                return library;
            }
        }
        
        return library;
    }

}
