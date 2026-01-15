package fr.centrale.nantes.infosi.tpnotemedev;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ChargementDictionnaire {

    public String chargement() throws IOException {
        InputStream is = null;
        String fileName = "dico.txt";
        is = getClass().getClassLoader().getResourceAsStream(fileName);
        if (is == null) {
            is = getClass().getResourceAsStream("/" + fileName);
        }

        if (is == null) {
            File f = new File(fileName);
            if (f.exists()) {
                is = new FileInputStream(f);
            }
        }
        if (is == null) {
            throw new IOException("Fichier '" + fileName + "' introuvable. ");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
            List<String> words = reader.lines()
                .map(String::trim)
                .filter(w -> !w.isEmpty())
                .filter(w -> w.matches("[a-zA-Z]+"))  
                .collect(Collectors.toList());

            if (words.isEmpty()) {
                throw new IOException("Le dictionnaire est vide ou ne contient aucun mot valide.");
            }

            return words.get(new Random().nextInt(words.size())).toUpperCase(); 
        }
    }
}