package accesstopostgre;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooser {
	public static String dBurlString = "";

	public String getUrl() {
		return FileChooser.dBurlString;
	}

	public static JFileChooser createFilePicker() {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		chooser.setDialogTitle("choosertitle");
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.addChoosableFileFilter(new FileNameExtensionFilter("Microsoft Access", "accdb"));
		chooser.addChoosableFileFilter(new FileNameExtensionFilter("Microsoft Access 2007 and earlier", "mdb"));
		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			dBurlString = "jdbc:ucanaccess://" + chooser.getSelectedFile();
			System.out.println(dBurlString);
		} else {
			System.out.println("Aucune selection");
			System.exit(0);
		}
		return chooser;
	}

}
