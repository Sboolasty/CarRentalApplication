package com.example.carrental.facade;


import com.example.carrental.domain.*;
import com.example.carrental.mapper.RaceTrackMapper;
import com.example.carrental.repositories.RaceTrackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RaceTrackFacade {

    private final RaceTrackRepository raceTrackRepository;
    private final RaceTrackMapper raceTrackMapper;

    public List<RaceTrackDto> getAllRaceTracks() {
        List<RaceTrack> raceTrackList = raceTrackRepository.findAll();
        return raceTrackMapper.mapToRaceTrackDtoList(raceTrackList);
    }

    public RaceTrackDto getRaceTrackDto(final long raceTrackId) {
        RaceTrack raceTrack = raceTrackRepository.findById(raceTrackId);
        return raceTrackMapper.mapToRaceTrackDto(raceTrack);
    }

    public Long saveRaceTrack(final RaceTrackDto raceTrackDto) {
        RaceTrack raceTrack = raceTrackMapper.mapToRaceTrack(raceTrackDto);
        raceTrackRepository.save(raceTrack);
        return raceTrack.getId();
    }

    public void deleteRaceTrack(final long raceTrackId) {
        raceTrackRepository.deleteById(raceTrackId);
    }

    public Long updateRaceTrackStatus(final long raceTrackId, final boolean status) {
        RaceTrack raceTrack = raceTrackRepository.findById(raceTrackId);
        raceTrack.setClosed(status);

        RaceTrack newStatusRaceTrack = raceTrackRepository.save(raceTrack);
        raceTrackMapper.mapToRaceTrackDto(newStatusRaceTrack);
        return newStatusRaceTrack.getId();
    }
}