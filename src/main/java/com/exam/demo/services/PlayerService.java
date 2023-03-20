package com.exam.demo.services;

import com.exam.demo.entities.Player;
import com.exam.demo.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void addPlayer(Player player) {
        this.playerRepository.saveAndFlush(player);
    }

    private void addTestPlayers20thCenturyMale() {
        for (int i = 0; i < 5; i++) {
            Player player = new Player();
            player.setId(38910020101L + i);
            player.setName("Vardas-" + i);
            player.setLastName("Pavarde-" + i);
            player.setEmail("Email" + i + "@email.com");
            player.setPlayStartDate(LocalDate.of(2002, 4 + i, 12 + i));
            this.playerRepository.saveAndFlush(player);
        }
    }

    private void addTestPlayers20thCenturyFemale() {
        for (int i = 0; i < 5; i++) {
            Player player = new Player();
            player.setId(49203290101L + i);
            player.setName("Vardas-" + i);
            player.setLastName("Pavarde-" + i);
            player.setEmail("Email" + i + "@email.com");
            player.setPlayStartDate(LocalDate.of(2007, 1 + i, 13 + i));
            this.playerRepository.saveAndFlush(player);
        }
    }

    private void addTestPlayers21stCenturyMale() {
        for (int i = 0; i < 5; i++) {
            Player player = new Player();
            player.setId(50111140101L + i);
            player.setName("Vardas-" + i);
            player.setLastName("Pavarde-" + i);
            player.setEmail("Email" + i + "@email.com");
            player.setPlayStartDate(LocalDate.of(2014, 3 + i, 14 + i));
            this.playerRepository.saveAndFlush(player);
        }
    }

    private void addTestPlayers21stCenturyFemale() {
        for (int i = 0; i < 5; i++) {
            Player player = new Player();
            player.setId(60212020101L + i);
            player.setName("Vardas-" + i);
            player.setLastName("Pavarde-" + i);
            player.setEmail("Email" + i + "@email.com");
            player.setPlayStartDate(LocalDate.of(2015, 6 + i, 15 + i));
            this.playerRepository.saveAndFlush(player);
        }
    }

    public void loadTestData() {
        addTestPlayers20thCenturyMale();
        addTestPlayers20thCenturyFemale();
        addTestPlayers21stCenturyMale();
        addTestPlayers21stCenturyFemale();
    }

    public List<Player> getPlayers() {
        return this.playerRepository.findAll();
    }

    public void printPlayers() {
        for (Player p : getPlayers())
            System.out.println(p);
    }

    public void deletePlayerById(Long id) {
        this.playerRepository.deleteById(id);
    }

    public void editPlayerByID(Long id, Player player) {
        Optional<Player> oldPlayerOptional = this.playerRepository.findById(id);

        if (!oldPlayerOptional.isPresent()) {
            return;
        }

        Player oldPlayer = oldPlayerOptional.get();

        if (player.getName() != null && !oldPlayer.getName().equals((player.getName()))) {
            oldPlayer.setName(player.getName());
        }

        if (player.getLastName() != null && !oldPlayer.getLastName().equals((player.getLastName()))) {
            oldPlayer.setLastName(player.getLastName());
        }

        if (player.getEmail() != null && !oldPlayer.getEmail().equals((player.getEmail()))) {
            oldPlayer.setEmail(player.getEmail());
        }

        /* I 117-118 eilutes rodo null poiter execption, siomis salygomis:
         * Jei zaidejas sukurtas be datos nuo kada pradejo zaisti sachmatais (PlayStartDate parametras) ir bandoma
         * jam prideti ta data frontende formoje pasiekiamoje paspaudus edit mygtuka.
         * Jei gali, paaiskink kodel, kazkaip ziuriu kuri laika, bet nebekompiliuoja galva, nors turbut kazkas labai paprasto, Aciu. */
        if (player.getPlayStartDate() != null && !oldPlayer.getPlayStartDate().equals((player.getPlayStartDate()))) {
            oldPlayer.setPlayStartDate(player.getPlayStartDate());
        }

        playerRepository.saveAndFlush(oldPlayer);
    }

    public Player getPlayerById(Long id) {
        Optional<Player> player = playerRepository.findById(id);

        if (!player.isPresent()) {
            return null;
        }

        return player.get();
    }

}