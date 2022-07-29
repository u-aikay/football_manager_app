package com.fm22.services;

import com.fm22.models.Players;
import java.util.List;

public interface PlayerService {
    public Players createPlayer(Players player);
    public Players getPlayer(Long id);
    public List<Players> getAllPlayers();
    public void removePlayer(Long id);
}
