package inc.pop.galaxy.model;

import java.io.PrintWriter;
import java.util.function.Consumer;

import inc.pop.domain.Galaxy;

public class Pattern {
	
	public enum InputType {
		CHECKBOX{public String get() { return "checkbox";}
		}, SUBMIT{public String get() { return "submit";}
		};
		public abstract String get();
	}
	
	public static Consumer<Object> infoListNote(PrintWriter out) {
		return g -> out.println("<li>" + g + "</li>");
	}
	
	public static Consumer<? super Galaxy> inputGalaxyNote(PrintWriter out, String type) {
		return g -> out.println("<li>" + g + "<input type=\"" + type + "\" name=\"galaxy-" + g.getId() + "\"></li>");
	}
}
