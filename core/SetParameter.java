package com.mygdx.game;

//import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
//import com.badlogic.gdx.graphics.g2d.BitmapFont;
//import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class SetParameter {
	private FreeTypeFontParameter parameter;
	int parNum;
	String chars;
	SetParameter(int parNum, String chars){
		this.parNum = parNum;
		this.chars = chars;
		this.parameter = ChooseParameter(parNum,chars);
	}
	
	public FreeTypeFontParameter setParameter(int size, Color col, int borNum, int sx, int sy, Color shadowCol, boolean isKerning, String chars){
		FreeTypeFontParameter par = new FreeTypeFontParameter();
		par.borderColor = col;
		par.borderWidth = borNum;
		par.shadowOffsetX = sx;
		par.shadowOffsetY = sy;
		par.size = size;
		par.shadowColor = shadowCol;
		par.kerning = isKerning;
		par.characters = chars;
		return par;
	}
	public FreeTypeFontParameter ChooseParameter(int parNum, String chars){
		FreeTypeFontParameter choosedPar = new FreeTypeFontParameter();
		// it can use system delay to print out different
		if(parNum == 1) {choosedPar = setParameter(40, Color.BLACK,3,3,3,Color.BLACK,false, chars);}
		else if (parNum == 2) {choosedPar = setParameter(40, Color.BLACK, 0, 3,3,Color.BLACK,false, chars);}
		else if (parNum == 3) {choosedPar = setParameter(40, Color.BLACK, 3, 0,0,Color.BLACK,false, chars);}
		else if (parNum == 4) {choosedPar = setParameter(40, Color.BLACK, 3, 3,3,Color.BLACK,true, chars);}
		else if (parNum == 5) {choosedPar = setParameter(40, Color.BLACK, 0, 0,0,Color.BLACK,true, chars);}
		else {choosedPar = setParameter(40, Color.BLACK,0, 0,0,Color.BLACK,true, chars);}
		
		return choosedPar;
	}
	
	public FreeTypeFontParameter getParameter(){
		return this.parameter;
	}
	
}
