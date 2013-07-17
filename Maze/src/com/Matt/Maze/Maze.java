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
			
		
		if((Gdx.input.isKeyPressed(Keys.DPAD_LEFT)) )
		{
			x += -10f;
		}
		
		if(Gdx.input.isKeyPressed(Keys.DPAD_RIGHT))
		{
			x += 10f;
		}
		
		if(Gdx.input.isKeyPressed(Keys.DPAD_UP))
		{
			y += 10f;
		}
	
		if(Gdx.input.isKeyPressed(Keys.DPAD_DOWN)) 
		{
			y += -10f;
		}
	
		if(x >= 614)
		{
			x = 614;
		}
		
		if(x <= -140)
		{
		x = -140;
		}
	
		if(y >= 260)
		{
			y= 260;
		}
	
	if(y<= -277)
	{
		y=-277;
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
