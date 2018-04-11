package fp.utiles;

import java.io.FileNotFoundException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

public class Musica {
	private static Thread fxThread = null;
	/* Espera 5 segundos antes de abortar escucha */
	private final static int MAX_INTENTOS = 50;

	/** 
	 * Reproduce el audio cuya URI es indicada mediante el parámetro.
	 * @param uri URI del audio a reproducir
	 */
	public static void reproduceMP3(String uri) {
		reproduceMP3(uri, Integer.MAX_VALUE / 1000);
	}

	/** 
	 * Reproduce, como máximo, maxSegundos del audio cuya URI es indicada mediante el parámetro.	 * 
	 * @param uri URI del audio a reproducir
	 * @param maxSegundos Número de segundos máximo a reproducir
	 */
	public static void reproduceMP3(String uri, Integer maxSegundos) {
		try {
			if (fxThread == null) {
				iniciaJavaFX();
			}			
			uri = uri.replace("https", "http");
			MediaPlayer player = new MediaPlayer(new Media(uri));
			esperaInicializacionReproductor(player, uri);
			player.play();
			esperaReproduccionCompleta(player, maxSegundos);			
			player.stop();
			player.dispose();			
		} catch (Exception e) {
			/*
			 * Si la uri no es válida, o es null, el método no reproduce nada, y
			 * acaba su ejecución de forma silenciosa.
			 */
		}
	}

	private static void esperaReproduccionCompleta(MediaPlayer player, Integer maxSegundos) throws InterruptedException {
		while (player.getStatus() != Status.PLAYING) {
			Thread.sleep(100);
		}
		Thread.sleep(Long.min(maxSegundos * 1000, (long) player.getStopTime().toMillis()));
	}

	private static void esperaInicializacionReproductor(MediaPlayer player, String uri) throws FileNotFoundException, InterruptedException {
		int intentos = 0;			
		while (player.getStatus() == Status.UNKNOWN) {
			Thread.sleep(100);
			intentos++;
			if (intentos == MAX_INTENTOS) {
				player.dispose();
				throw new FileNotFoundException("No se puede abrir " + uri);
			}
		}
	}

	private static void iniciaJavaFX() {
		fxThread = new Thread() {
			public void run() {
				new javafx.embed.swing.JFXPanel();
			};
		};
		fxThread.setDaemon(true);
		fxThread.start();
	}
}
