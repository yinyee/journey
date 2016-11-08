package util;

public class JSON {
	
	private double age, weight, height, gender, african, asian, caucasian;
	private double[] muscle, breastSize, breastVolume, headOval;
	private final static String LBRACE = "{";
	private final static String RBRACE = "}";
	private final static String COMMA = ",";
	private final static String COLON = ":";
	
	public JSON(double age, double weight, double height, double gender, double african, double asian, double caucasian,
			double[] muscle, double[] breastSize, double[] breastVolume, double[] headOval) {
		this.age = age;
		this.weight = weight;
		this.height= height;
		this.gender = gender;
		this.african = african;
		this.asian = asian;
		this.caucasian = caucasian;
		this.muscle = muscle;
		this.breastSize = breastSize;
		this.breastVolume = breastVolume;
		this.headOval = headOval;
	}
	
	public String[] jsonify() {
		
		String[] jsonArray = new String[5];
		
		for (int i = 0; i < 5; i++) {
			
			StringBuilder str = new StringBuilder();
			
			str.append(LBRACE);
			
			str.append("macrodetails/Age");
			str.append(COLON);
			str.append("0.5");
			str.append(COMMA);
			
			str.append("macrodetails-universal/Weight");
			str.append(COLON);
			str.append("0.5");
			str.append(COMMA);
			
			str.append("macrodetails-height/Height");
			str.append(COLON);
			str.append("0.5");
			str.append(COMMA);
			
			str.append("macrodetails/Gender");
			str.append(COLON);
			str.append(gender);
			str.append(COMMA);
			
			str.append("macrodetails/African");
			str.append(COLON);
			str.append(african);
			str.append(COMMA);
			
			str.append("macrodetails/Asian");
			str.append(COLON);
			str.append(asian);
			str.append(COMMA);
			
			str.append("macrodetails/Caucasian");
			str.append(COLON);
			str.append(caucasian);
			str.append(COMMA);
			
			str.append("macrodetails-universal/Muscle");
			str.append(COLON);
			str.append(muscle[i]);
			str.append(COMMA);
			
			str.append("breast/BreastSize");
			str.append(COLON);
			str.append(breastSize[i]);
			str.append(COMMA);
			
			str.append("breastVolume");
			str.append(COLON);
			str.append(breastVolume[i]);
			str.append(COMMA);
			
			str.append("head/head-oval");
			str.append(COLON);
			str.append(headOval[i]);
			
			str.append(RBRACE);
			
			jsonArray[i] = str.toString();
			System.out.println(str.toString());
		}
		
		return jsonArray;
		
	}
}
