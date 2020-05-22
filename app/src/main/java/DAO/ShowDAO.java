package DAO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Show;

public class ShowDAO {
    public List<Show> lista() {
        List<Show> shows = new ArrayList<>(Arrays.asList(
                new Show("Scalene", "Palácio das Artes", "scalene", new BigDecimal(45.90), "17/04/2021", "Sab - 21:00"),
                new Show("Supercombo", "Sesc Palladium", "supercombo", new BigDecimal(45.90), "10/07/2021", "Sex - 22:00"),
                new Show("Chico e o mar", "A Autêntica", "chico_eo_mar", new BigDecimal(19.90), "10/09/2021", "Sex - 22:00"),
                new Show("Zimbra", "Jack Rock Bar", "zimbra", new BigDecimal(30.00), "17/09/2021", "Sab - 21:30"),
                new Show("Selvagens à Procura de Lei", "Palácio das Artes", "selvagens_a_procura_de_lei", new BigDecimal(45.90), "03/10/2021", "Dom - 19:00"),
                new Show("Los Hermanos", "Mineirão", "los_hermanos", new BigDecimal(120.50), "20/11/2021", "Sab - 21:00")));
        return shows;
    }
}
