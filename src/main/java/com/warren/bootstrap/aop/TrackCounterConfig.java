package com.warren.bootstrap.aop;

import com.warren.bootstrap.soundsystem.BlankDisc;
import com.warren.bootstrap.soundsystem.CompactDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/5 10:47
 */
@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {

	@Bean
	public CompactDisc setPeppers(){
		BlankDisc cd=new BlankDisc();
		cd.setTitle("Sgt. Pepper's Lonely Hearts");
		cd.setArtist("The Beatles");
		List<String> tracks=new ArrayList<>();
		tracks.add("Sgt. Pepper's Lonely Hearts");
		tracks.add("With a Little Help from My Friends");
		tracks.add("Lucy in th Sky with Diamonds");
		tracks.add("Getting Better");
		tracks.add("Fixing a Hole");
		cd.setTracks(tracks);
		return cd;
	}
	@Bean
	public TrackCounter trackCounter(){
		return new TrackCounter();
	}
}
