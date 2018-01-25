package com.soundclout.tycoon.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.soundclout.tycoon.MyTycoonGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
               // TexturePacker.process("memes", "packed", "player");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new MyTycoonGame(), config);
	}
}
