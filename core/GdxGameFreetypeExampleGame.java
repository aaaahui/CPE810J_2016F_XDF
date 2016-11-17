package com.mygdx.game;

import java.util.Locale;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.FontFactory;


public class GdxGameFreetypeExampleGame extends ApplicationAdapter {
	
	// Messages
	public static final String SPANISH_MESSAGE = "¡Hola Mundo! hello 123";
	public static final String RUSSIAN_MESSAGE = "Привет мир!! 123 hello";
	public static final String CHINESE_MESSAGE = "今天建设新中国，fighting!666";
	
	// Batch
	private SpriteBatch batch;
	
	// Locales for languages
	private Locale esLocale;
	private Locale ruLocale;
	private Locale cnLocale;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		
		// Initialize FontFactory
		FontFactory.getInstance().initialize(1,2,3);
		//Choose the number to get different type of fonts
		
		// Initialize locales
		esLocale = new Locale("es", "ES");
		ruLocale = new Locale("ru", "RU");
		cnLocale = new Locale("cn", "CN");
	}

	@Override
	public void render () {
		// Clear screen
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Draw with fonts
		batch.begin();
		FontFactory.getInstance().getFont(esLocale).draw(batch, SPANISH_MESSAGE, 120.f, 700.f);
		FontFactory.getInstance().getFont(ruLocale).draw(batch, RUSSIAN_MESSAGE, 120.f, 500.f);
		FontFactory.getInstance().getFont(cnLocale).draw(batch, CHINESE_MESSAGE, 120.f, 300.f);
		batch.end();
		
	}

	@Override
	public void dispose() {
		super.dispose();
		FontFactory.getInstance().dispose();
	}
	
}
