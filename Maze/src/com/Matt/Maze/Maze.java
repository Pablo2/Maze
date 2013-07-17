package com.Matt.Maze;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Maze implements ApplicationListener {
	private SpriteBatch batch;
	private Texture texture;
	
	float x = 0.0f;
	float y = 0.0f;
	
	@Override
	public void create() 
	{		
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
	}
	
	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}
	
	float xDelta = 0.1f;
	
	public void update()
	{
		x += 0.1f;
		y += 0.1f;	
		
		if(x > 10)
		{
			xDelta = -xDelta;
		}
	}

	@Override
	public void render() 
	{	
		update();
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
			batch.draw(texture, x, y);
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
