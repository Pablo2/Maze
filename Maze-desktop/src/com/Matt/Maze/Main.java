package com.Matt.Maze;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;


public class Main {
	public static void main(String[] args) 
	{
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Maze";
		cfg.useGL20 = false;
		cfg.width = 280;
		cfg.height = 280;
		
		new LwjglApplication(new Maze(), cfg);
	}
}