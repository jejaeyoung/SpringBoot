package com.example.Lookify.control;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Lookify.model.Song;
import com.example.Lookify.service.SongService;

@Controller
public class HomeController {
	
	@Autowired
	SongService songService;
	
	//main menu
	@GetMapping("/")
	private String index()
	{
		return "index.jsp";
	}
	
	//dashboard for top 10
	@GetMapping("/dashboard")
	private String dashboard(Model gx, Long id)
	{
		gx.addAttribute("songs", songService.allSongs());
		return "dashboard.jsp";
	}
	
	//search for topten
	@GetMapping("/search/topTen")
	private String topTen(Model gx, Long id)
	{
		gx.addAttribute("songs", songService.topSongs());
		return "toptensong.jsp";
	}
	
	//add new artist
	@GetMapping("/songs/new")
	private String newSong(@ModelAttribute("song") Song nsong, Long id)
	{
		return "newsong.jsp";
	}
	
	//process for new artist
	@PostMapping("songs/process")
	private String processSong(@Valid @ModelAttribute("song")Song nsong, BindingResult res)
	{
		if (res.hasErrors())
		{
			return "newsong.jsp";
		}
		else
		{
			songService.createSong(nsong);
			return "redirect:/dashboard";
		}
	}
	//deleting for dashboard data
	@DeleteMapping("/songs/{id}")
	private String deleteSong(@PathVariable("id") Long delete, Model mg)
	{
		songService.deleteSong(delete);
		return "redirect:/dashboard";
	}
	
	//show artist
	@GetMapping("/songs/{id}")
	private String showArtist (@PathVariable("id")Long id, Model gx)
	{
		gx.addAttribute("song", songService.findSong(id));
		return "showsong.jsp";
	}
	
	//Search Artist
	@GetMapping("/search")
	private String searchArtist(@RequestParam("artist")String artist,  Model gx)
	{
		List<Song> songs = songService.songArtist(artist);
		gx.addAttribute("artist", artist);
		gx.addAttribute("songs", songs);
		return "search.jsp";
	}
	
	
}


