package keller_project2;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Comparator;
import java.util.Scanner;
import javafx.scene.control.Alert;

/**
 *
 * @author Jack Keller
 */
public class Media implements Serializable {

    private String title;
    private String format;
    private boolean loaned;
    private LocalDate date;
    private String loanee;

    public Media(String title, String format) {
        this.title = title;
        this.format = format;
        this.loaned = false;

    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }
    
    public boolean getLoaned() {
        return loaned;
    }

    public void loan(String loanee, LocalDate date) {
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
        this.date = null;
    }

    @Override
    public String toString() {
        if (loaned) {
            return "\n" + title + " - " + format + ", Loaned to " + loanee + " on " + date;
        } else {
            return "\n" + title + " - " + format;
        }
    }

    public static Comparator<Media> MediaTitleComparator = new Comparator<Media>() {

        public int compare(Media m1, Media m2) {
            String MediaTitle1 = m1.getTitle().toUpperCase();
            String MediaTitle2 = m2.getTitle().toUpperCase();

            return MediaTitle1.compareTo(MediaTitle2);
        }
    };

    public static Comparator<Media> MediaDateComparator = new Comparator<Media>() {

        public int compare(Media m1, Media m2) {
            if (m1.getDate() == null && m2.getDate() == null) {
                return 0;
            } else if (m1.getDate() == null && m2.getDate() != null) {
                return 1;
            } else if (m1.getDate() != null && m2.getDate() == null) {
                return -1;
            }
            LocalDate MediaDate1 = m1.getDate();
            LocalDate MediaDate2 = m2.getDate();

            return -MediaDate1.compareTo(MediaDate2);
        }
    };

    // This function takes the library and the choice (either 1 or 5) and checks
    // the library for the specified media. It then either adds or removes the 
    // media.
    public ArrayList<Media> editLibrary(ArrayList<Media> library, int choice) {
        if (choice == 1) {
            for (Media m : library) {
                if (title.compareTo(m.getTitle()) == 0) {
                    return library;
                }
            }

            library.add(this);

            return library;
        } else if (choice == 5) {
            for (Media m : library) {
                if (title.compareTo(m.getTitle()) == 0) {
                    library.remove(m);
                    return library;
                }

                return library;
            }
        }

        return library;
    }

}
