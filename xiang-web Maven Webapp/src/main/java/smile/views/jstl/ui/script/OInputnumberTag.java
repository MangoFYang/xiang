package smile.views.jstl.ui.script;

import smile.components.Component;
import smile.components.script.OInputnumber;

public class OInputnumberTag extends OTextFieldTag {

	private static final long serialVersionUID = 2439905956360736589L;
	
	protected String decimal;
	protected String max;
	protected String min;
	protected String step;
	protected String page;
	protected String change;
	protected String start;
	protected String spin;
	protected String stop;
	
    @Override
	public Component getBean() {
		return new OInputnumber();
	}

	protected void populateParams() {
        super.populateParams();
        OInputnumber oinputnumber = (OInputnumber) component;
        oinputnumber.setDecimal(decimal);
        oinputnumber.setMax(max);
        oinputnumber.setMin(min);
        oinputnumber.setStep(step);
        oinputnumber.setPage(page);
        oinputnumber.setChange(change);
        oinputnumber.setStart(start);
        oinputnumber.setSpin(spin);
        oinputnumber.setStop(stop);
    }

	public void setDecimal(String decimal) {
		this.decimal = decimal;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public void setSpin(String spin) {
		this.spin = spin;
	}

	public void setStop(String stop) {
		this.stop = stop;
	}

}
