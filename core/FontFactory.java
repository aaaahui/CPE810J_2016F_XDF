package com.mygdx.game;

import java.util.Locale;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
//import com.mygdx.game.*;
//import com.badlogic.gdx.graphics.Color;

public class FontFactory {
	
	// Font names
	public static final String SPANISH_FONT_NAME = "fonts/goodfish rg.ttf";
	public static final String RUSSIAN_FONT_NAME = "fonts/Imperial Web.ttf";
	public static final String CHINESE_FONT_NAME = "fonts/data1.TTF";
	
	// Russian cyrillic characters
	public static final String RUSSIAN_CHARACTERS = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"
            + "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
            + "1234567890.,:;_¡!¿?\"'+-*/()[]={}";
	
	public static final String CHINESE_CHARACTERS = "今天天气真好，建设新中国";
	// Singleton: unique instance
	private static FontFactory instance;
	
	
	private BitmapFont esFont;
	private BitmapFont ruFont;
	private BitmapFont cnFont;
	
	/** Private constructor for singleton pattern */
	private FontFactory() { super(); }
	
	public static synchronized FontFactory getInstance() {
		if (instance == null) {
			instance = new FontFactory();
		}
		return instance;
	}
	
	public void initialize(int esType, int ruType, int cnType) {
		// If fonts are already generated, dispose it!
		if (esFont != null) esFont.dispose();
		if (ruFont != null) ruFont.dispose();
		if (cnFont != null) cnFont.dispose();
		esFont = generateFont(esType,SPANISH_FONT_NAME, FreeTypeFontGenerator.DEFAULT_CHARS,Color.BLUE);
		ruFont = generateFont(ruType,RUSSIAN_FONT_NAME, FreeTypeFontGenerator.DEFAULT_CHARS+RUSSIAN_CHARACTERS, Color.ORANGE);
		cnFont = generateFont(cnType,CHINESE_FONT_NAME, FreeTypeFontGenerator.DEFAULT_CHARS+CHINESE_CHARACTERS, Color.PINK);
	}
	
	/**
	 * Generate a BitmapFont with font name and characters received as params
	 * 
	 * @param fontName    Font name
	 * @param characters  Characters to generate
	 * 
	 * @return Generated BitmapFont
	 */
	
	public BitmapFont generateFont(int typeNum, String fontName, String characters, Color col) {
		
		// Configure font parameters
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		SetParameter Set = new SetParameter(typeNum, characters);
	    parameter = Set.getParameter();
		// Generate font
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator( Gdx.files.internal(fontName) );
		BitmapFont font = generator.generateFont(parameter);
		font.setColor(col);
		// Dispose resources
		generator.dispose();
		
		return font;
	}
	
	/**
	 * Get font for param locale
	 * 
	 * @param locale  locale
	 * @return BitmapFont
	 */
	public BitmapFont getFont(Locale locale) {
		if      ("es".equals(locale.getLanguage())) return esFont;
		else if ("ru".equals(locale.getLanguage())) return ruFont;
		else if ("cn".equals(locale.getLanguage())) return cnFont;
		else throw new IllegalArgumentException("Not supported language");
	}
	
	/**
	 * Dispose resources
	 */
	public void dispose() {
		esFont.dispose();
		ruFont.dispose();
		cnFont.dispose();
	}
}
