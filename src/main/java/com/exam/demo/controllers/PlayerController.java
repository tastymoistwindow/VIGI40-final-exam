package com.exam.demo.controllers;

import com.exam.demo.converters.PlayerConverter;
import com.exam.demo.dto.AddPlayerDTO;
import com.exam.demo.dto.PlayerDTO;
import com.exam.demo.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<PlayerDTO> getPlayers() {
        return PlayerConverter.convertPlayerEntityListToDto(this.playerService.getPlayers());
    }

    @GetMapping("/{id}")
    public PlayerDTO getPlayerById(@PathVariable Long id) {
        return PlayerConverter.convertPlayerEntityToDto(this.playerService.getPlayerById(id));
    }

    @PostMapping
    public void addPlayer(@RequestBody AddPlayerDTO playerDTO) {
        this.playerService.addPlayer(PlayerConverter.convertAddPlayerDtoToEntity(playerDTO));
    }

    @DeleteMapping("/{id}")
    public void deletePlayerById(@PathVariable Long id) {
        this.playerService.deletePlayerById(id);
    }

    @PatchMapping("/{id}")
    public void editPlayerById(@PathVariable Long id, @RequestBody AddPlayerDTO playerDTO) {
        this.playerService.editPlayerByID(id,PlayerConverter.convertAddPlayerDtoToEntity(playerDTO));
    }

}
