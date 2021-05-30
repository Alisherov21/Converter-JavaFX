package Converter;

public class VolumeConverter extends ConverterPane {

	private String title = "Distance Converter";
	private String[] options = {
			"m3 - Cubic metre", 
			"b - Barrel", 
			"f3 - Cubic foot", 
			"dm3 - Cubic decimetre", 
			"l - Litre", 
			"g - Gallon (US)",
			"p - Pint (US)",
			"in3 - Cubic inch",
			"cm3 - Cubic centimetre",
	};
	private String fromUnit;
	private String toUnit;
	private String fromValue;
	
	public VolumeConverter() {
		setTitle(title);
		setOptions(options);
		
		button.setOnMouseClicked(event -> {
			
			fromUnit = getFromUnit();
			toUnit = getToUnit();
			fromValue = getValueFrom();
			double value;
			double meterLength;
			double result;
			try {
				value = Double.parseDouble(fromValue);
				if ((meterLength = convertToMeter(value, fromUnit)) >= 0) {
					result = convertToUnit(meterLength, toUnit);
					textOut.setText("" + df.format(result));
				} else {
					textOut.setText("Volume can't be lower than zero!");
				}
			} catch (NumberFormatException e) {
				textOut.setText("Bad number");
			}
		});
	}
	
	private double convertToMeter(double value, String fromUnit) {
		double result = 0;
		switch(fromUnit) {
		case "m3":
			result = value * 1000;
			break;
		case "b":
			result = value * 158.987294928;
			break;
		case "f3":
			result = value * 28.316864592;
			break;
		case "dm3":
			result = value;
			break;
		case "l":
			result = value;
			break;
		case "g":
			result = value * 3.785411784;
			break;
		case "p":
			result = value * 0.473176473;
			break;
		case "in3":
			result = value * 0.016387064;
			break;
		case "cm3":
			result = value / 1000;
			break;
		}
		return result;
	}
	
	private double convertToUnit(double value, String toUnit) {
		double result = 0;
		switch(toUnit) {
		case "m3":
			result = value / 1000;
			break;
		case "b":
			result = value / 158.987294928;
			break;
		case "f3":
			result = value / 28.316864592;
			break;
		case "dm3":
			result = value;
			break;
		case "l":
			result = value;
			break;
		case "g":
			result = value / 3.785411784;
			break;
		case "p":
			result = value / 0.473176473;
			break;
		case "in3":
			result = value / 0.016387064;
			break;
		case "cm3":
			result = value * 1000;
			break;
		}
		return result;
	}
}
