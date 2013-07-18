package com.Matt.Maze;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Maze implements ApplicationListener {
	private SpriteBatch batch;
	private Texture mario;
	private Texture maze;
	private Rectangle rect1;
	
	private int width = 484;
	private int height = 260;
	private int tileWidth = 484/11;
	private int tileHeight = 260/7;
	
	private Tile[][] tileMap = new Tile[7][11]; //y,x
	
	float marioX = tileWidth / 2;
	float marioY = tileHeight/ 2;
	
	@Override
	public void create() 
	{		
		batch = new SpriteBatch();
		
		mario = new Texture(Gdx.files.internal("data/libgdx.png"));
		maze = new Texture(Gdx.files.internal("data/maze.png"));
		rect1 = new Rectangle();
		
		for(int y = 0; y < tileMap.length; y++)
		{
			for(int x = 0; x < tileMap.length; x++)
			{
				tileMap[y][x] = new Tile();
			}
		}
		
		tileMap[0][0].up = true;
	}
	
	@Override
	public void dispose() {
		batch.dispose();
		mario.dispose();
	}
	
	float xDelta = 0.1f;
	
	public void update()
	{
		int marioTileX = (int)(marioX / tileWidth);
		int marioTileY = (int)(marioY / tileHeight);
		
		if((Gdx.input.isKeyPressed(Keys.DPAD_LEFT)) )
		{
			marioX += -tileWidth;;
		}
		
		if(Gdx.input.isKeyPressed(Keys.DPAD_RIGHT))
		{
			marioX += tileWidth;;
		}
		
		if(Gdx.input.isKeyPressed(Keys.DPAD_UP))
		{
			if(tileMap[marioTileY][marioTileX].up)
			{
				marioY += tileHeight;;
			}
		}
	
		if(Gdx.input.isKeyPressed(Keys.DPAD_DOWN)) 
		{
			marioY += -tileHeight;;
		}
	
		if(marioX >= 484)
		{
			marioX = 484;
		}
		if(marioX <= -6)
		{
		marioX = -6;
		}
	
		if(marioY >= 260)
		{
			marioY= 260;
		}
	
	if(marioY<= -45)
	{
		marioY=-45;
	}
	}
	

	@Override
	public void render() 
	{	
		update();
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		batch.draw(maze, 0,0);	
		batch.draw(mario, marioX, marioY);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
