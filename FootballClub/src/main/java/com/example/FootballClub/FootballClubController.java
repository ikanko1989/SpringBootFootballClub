package com.example.FootballClub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clubs")
public class FootballClubController {
    @Autowired
    private FootballClubService footballClubService;

    @GetMapping
    public List<FootballClub> getAllClubs() {
        return footballClubService.getAllClubs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FootballClub> getClubById(@PathVariable Long id) {
        Optional<FootballClub> club = footballClubService.getClubById(id);

        if (club.isPresent()) {
            FootballClub club1 = club.get();
            return new ResponseEntity<>(club1, HttpStatus.OK);  // 200 OK with club data
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // 404 Not Found, no body
        }
    }

    @PostMapping
    public FootballClub addClub(@RequestBody FootballClub club){
        return footballClubService.addClub(club);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteClub(@PathVariable Long id) {
        footballClubService.deleteClub(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
