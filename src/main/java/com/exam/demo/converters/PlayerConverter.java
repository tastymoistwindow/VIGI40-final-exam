package com.exam.demo.converters;

import com.exam.demo.dto.AddPlayerDTO;
import com.exam.demo.dto.PlayerDTO;
import com.exam.demo.entities.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class PlayerConverter {

    public static Player convertAddPlayerDtoToEntity(AddPlayerDTO playerDTO) {
        Player player = null;
        if (playerDTO != null) {
            player = new Player();
            player.setId(playerDTO.getId());
            player.setName(playerDTO.getName());
            player.setLastName(playerDTO.getLastName());
            player.setEmail(playerDTO.getEmail());
            player.setPlayStartDate(playerDTO.getPlayStartDate());
        }
        return player;
    }

    public static PlayerDTO convertPlayerEntityToDto(Player player) {
        PlayerDTO playerDTO = null;
        if (player != null) {
            playerDTO = new PlayerDTO();
            playerDTO.setId(player.getId());
            playerDTO.setName(player.getName());
            playerDTO.setLastName(player.getLastName());
            playerDTO.setEmail(player.getEmail());
            playerDTO.setSex(playerDTO.getSex());
            playerDTO.setAge(playerDTO.getAge());
            playerDTO.setPlayStartDate(player.getPlayStartDate());
            playerDTO.setPlayerExperience(playerDTO.getPlayerExperience());
        }
        return playerDTO;
    }

    public static List<PlayerDTO> convertPlayerEntityListToDto(List<Player> playerList) {
        List<PlayerDTO> playerDTOList = null;
        for (Player p : playerList) {
            if (playerDTOList == null) {
                playerDTOList = new ArrayList<>();
            }
            playerDTOList.add(PlayerConverter.convertPlayerEntityToDto(p));
        }
        return playerDTOList;
    }
}


