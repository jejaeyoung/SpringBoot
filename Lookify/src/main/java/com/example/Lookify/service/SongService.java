package com.example.Lookify.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.Lookify.model.Song;
import com.example.Lookify.repository.SongRepository;

@Service
public class SongService {
	
		private final SongRepository songRepo; 

		
		public SongService(SongRepository songRepo) {
			this.songRepo = songRepo;

		}

	
		public List<Song> allSongs() {
			return songRepo.findAll();

		}

		
		public List<Song> songArtist(String artist) {
			return songRepo.findByArtistContaining(artist);

		}

		public List<Song> topSongs() {
			return songRepo.findTop10ByOrderByRatingDesc();

		}

		
		public Song findSong(Long id) {
			
			return this.songRepo.findById(id).orElse(null);
		}

		public Song createSong(Song song) {
			return songRepo.save(song);

		}

		public void deleteSong(Long id) {
			
				this.songRepo.deleteById(id);
			
		}
	}
