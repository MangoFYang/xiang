package smile.components.script;

public class OInputnumber extends OTextField {
	
    /**
     * OInputnumberTag默认的模板名
     */
    public static final String TEMPLATE = "oinputnumber";
	
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
	protected void evaluateParams() {
		super.evaluateParams();
		if(decimal != null) {
			this.addParameter("decimal", decimal);
		}
		if(max != null) {
			this.addParameter("max", max);
		}
		if(min != null) {
			this.addParameter("min", min);
		}
		if(step != null) {
			this.addParameter("step", step);
		}
		if(page != null) {
			this.addParameter("page", page);
		}
		if(change != null) {
			this.addParameter("change", change);
		}
		if(start != null) {
			this.addParameter("start", start);
		}
		if(spin != null) {
			this.addParameter("spin", spin);
		}
		if(stop != null) {
			this.addParameter("stop", stop);
		}
	}

	@Override
	protected String getDefaultTemplate() {
		return TEMPLATE;
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
