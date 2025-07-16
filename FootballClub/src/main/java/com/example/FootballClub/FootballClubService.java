package com.example.FootballClub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FootballClubService {

    @Autowired // <-- field injection here
    private FootballClubRepository footballClubRepository;

    //Constructor injection (commented out)
    //public FootballClubService(FootballClubRepository footballClubRepository){
    // this.footballClubRepository=footballClubRepository;}

    public List<FootballClub>getAllClubs(){
        return footballClubRepository.findAll();
    }

    public Optional<FootballClub>getClubById(Long id){
        return footballClubRepository.findById(id);
    }

    public FootballClub addClub(FootballClub club){
        return footballClubRepository.save(club);
    }

    public void deleteClub(Long id){
        footballClubRepository.deleteById(id);
    }


}
