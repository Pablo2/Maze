package com.Matt.Maze;

import java.util.HashMap;

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
	
	private int width = 484;
	private int height = 260;
	private int tileWidth = 484/11;
	private int tileHeight = 260/7;
	
	private HashMap<Integer, Boolean> keyP = new HashMap<Integer, Boolean>();
	
	private Tile[][] tileMap = new Tile[20][20]; //y,x
	
	float marioX = tileWidth / 2;
	float marioY = tileHeight/ 2;
	
	@Override
	public void create() 
	{		
		batch = new SpriteBatch();
		
		mario = new Texture(Gdx.files.internal("data/libgdx.png"));
		maze = new Texture(Gdx.files.internal("data/maze.png"));
		
		for(int y = 0; y < tileMap.length; y++)
		{
			for(int x = 0; x < tileMap.length; x++)
			{
				tileMap[y][x] = new Tile();
			}
		}
		tileMap[0][0].up = true;
		tileMap[0][0].left = false;
		tileMap[0][0].right = false;
		tileMap[1][0].up = true;
		tileMap[2][0].up=true;
		tileMap[3][0].up=true;
		tileMap[4][0].up=true;
		tileMap[5][0].up=true;
		tileMap[6][0].up=true;
		tileMap[1][0].down = true;
		tileMap[2][0].down=true;
		tileMap[3][0].down=true;
		tileMap[4][0].down=true;
		tileMap[5][0].down=true;
		tileMap[7][0].up=false;
		tileMap[7][0].down=true;
		tileMap[6][0].down=true;
		tileMap[6][0].right=true;
		tileMap[6][1].down=true;
		tileMap[6][1].up=true;
		tileMap[6][1].left=true;
		tileMap[7][0].right=true;
		tileMap[0][1].up = true;
		tileMap[1][1].up=true;
		tileMap[2][1].up=true;
		tileMap[4][1].up=true;
		tileMap[5][1].up=true;
		tileMap[7][1].right = true;
		tileMap[4][1].right = true;
		tileMap[7][2].right = true;
		tileMap[7][3].right = true;
		tileMap[7][4].right = true;
		tileMap[7][5].right = true;
		tileMap[7][6].right = true;
		tileMap[7][7].right = true;
		tileMap[7][8].right = true;
		tileMap[7][9].right = true;
		tileMap[0][1].right = true;
		tileMap[2][1].right = true;
		tileMap[0][2].right = true;
		tileMap[0][3].right = true;
		tileMap[0][4].right = true;
		tileMap[0][5].right = true;
		tileMap[0][6].right = true;
		tileMap[0][7].right = true;
		tileMap[2][1].right = true;
		tileMap[2][2].right = true;
		tileMap[2][3].right = true;
		tileMap[2][4].right = true;
		tileMap[2][5].right = true;
		tileMap[5][7].right = true;
		tileMap[5][8].right = true;
		tileMap[5][9].right = true;
		tileMap[5][10].right = true;
	}
	
	@Override
	public void dispose() {
		batch.dispose();
		mario.dispose();
	}
	
	float xDelta = 0.01f;
	
	public void update()
	{
		int marioTileX = (int)(marioX / tileWidth);
		int marioTileY = (int)(marioY / tileHeight);
		
		if(Gdx.input.isKeyPressed(Keys.DPAD_LEFT))
		{
			if( (!keyP.get(Keys.DPAD_LEFT)))
			{
				if(tileMap[marioTileY][marioTileX].left)
				{
					keyP.put(Keys.DPAD_LEFT, true);
					marioX += -tileWidth;;
				}
			}
		}
		else
		{
			keyP.put(Keys.DPAD_LEFT, false);
		}
		
		if(Gdx.input.isKeyPressed(Keys.DPAD_RIGHT))
		{
			if( (!keyP.get(Keys.DPAD_RIGHT)))
			{
			if(tileMap[marioTileY][marioTileX].right)
			{
				keyP.put(Keys.DPAD_RIGHT, true);
				marioX += tileWidth;;
			}
		}
	}
		else
		{
			keyP.put(Keys.DPAD_RIGHT, false);
		}
		if(Gdx.input.isKeyPressed(Keys.DPAD_UP))
		{
			if( (!keyP.get(Keys.DPAD_UP)))
			{
				if(tileMap[marioTileY][marioTileX].up)
				{
					keyP.put(Keys.DPAD_UP, true);
					marioY += tileHeight;;
				}
			}
		}
		else
		{
			keyP.put(Keys.DPAD_UP, false);
		}
	
		if(Gdx.input.isKeyPressed(Keys.DPAD_DOWN)) 
		{
			if ( (!keyP.get(Keys.DPAD_DOWN)))
			{
			if(tileMap[marioTileY][marioTileX].down)
			{
				keyP.put(Keys.DPAD_DOWN, true);
				marioY += -tileHeight;;
			}
		}
	}
		else
		{
			keyP.put(Keys.DPAD_DOWN, false);
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
