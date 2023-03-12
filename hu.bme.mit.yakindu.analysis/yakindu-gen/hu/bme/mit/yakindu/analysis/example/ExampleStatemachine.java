/** Generated by YAKINDU Statechart Tools code generator. */
package hu.bme.mit.yakindu.analysis.example;

import hu.bme.mit.yakindu.analysis.ITimer;

public class ExampleStatemachine implements IExampleStatemachine {
	protected class SCInterfaceImpl implements SCInterface {
	
		private boolean start;
		
		public void raiseStart() {
			start = true;
		}
		
		private boolean white;
		
		public void raiseWhite() {
			white = true;
		}
		
		private boolean black;
		
		public void raiseBlack() {
			black = true;
		}
		
		private boolean trap;
		
		public void raiseTrap() {
			trap = true;
		}
		
		private long whiteTime;
		
		public long getWhiteTime() {
			return whiteTime;
		}
		
		public void setWhiteTime(long value) {
			this.whiteTime = value;
		}
		
		private long blackTime;
		
		public long getBlackTime() {
			return blackTime;
		}
		
		public void setBlackTime(long value) {
			this.blackTime = value;
		}
		
		protected void clearEvents() {
			start = false;
			white = false;
			black = false;
			trap = false;
		}
	}
	
	protected SCInterfaceImpl sCInterface;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_Init,
		main_region_Black,
		main_region_White,
		main_region_trap,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	
	private ITimer timer;
	
	private final boolean[] timeEvents = new boolean[2];
	public ExampleStatemachine() {
		sCInterface = new SCInterfaceImpl();
	}
	
	public void init() {
		this.initialized = true;
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
		sCInterface.setWhiteTime(60);
		
		sCInterface.setBlackTime(60);
	}
	
	public void enter() {
		if (!initialized) {
			throw new IllegalStateException(
				"The state machine needs to be initialized first by calling the init() function."
			);
		}
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		enterSequence_main_region_default();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case main_region_Init:
				main_region_Init_react(true);
				break;
			case main_region_Black:
				main_region_Black_react(true);
				break;
			case main_region_White:
				main_region_White_react(true);
				break;
			case main_region_trap:
				main_region_trap_react(true);
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
	public void exit() {
		exitSequence_main_region();
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NullState$;
	}
	
	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	* @see IStatemachine#isFinal()
	*/
	public boolean isFinal() {
		return false;
	}
	/**
	* This method resets the incoming events (time events included).
	*/
	protected void clearEvents() {
		sCInterface.clearEvents();
		for (int i=0; i<timeEvents.length; i++) {
			timeEvents[i] = false;
		}
	}
	
	/**
	* This method resets the outgoing events.
	*/
	protected void clearOutEvents() {
	}
	
	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
	
		switch (state) {
		case main_region_Init:
			return stateVector[0] == State.main_region_Init;
		case main_region_Black:
			return stateVector[0] == State.main_region_Black;
		case main_region_White:
			return stateVector[0] == State.main_region_White;
		case main_region_trap:
			return stateVector[0] == State.main_region_trap;
		default:
			return false;
		}
	}
	
	/**
	* Set the {@link ITimer} for the state machine. It must be set
	* externally on a timed state machine before a run cycle can be correctly
	* executed.
	* 
	* @param timer
	*/
	public void setTimer(ITimer timer) {
		this.timer = timer;
	}
	
	/**
	* Returns the currently used timer.
	* 
	* @return {@link ITimer}
	*/
	public ITimer getTimer() {
		return timer;
	}
	
	public void timeElapsed(int eventID) {
		timeEvents[eventID] = true;
	}
	
	public SCInterface getSCInterface() {
		return sCInterface;
	}
	
	public void raiseStart() {
		sCInterface.raiseStart();
	}
	
	public void raiseWhite() {
		sCInterface.raiseWhite();
	}
	
	public void raiseBlack() {
		sCInterface.raiseBlack();
	}
	
	public void raiseTrap() {
		sCInterface.raiseTrap();
	}
	
	public long getWhiteTime() {
		return sCInterface.getWhiteTime();
	}
	
	public void setWhiteTime(long value) {
		sCInterface.setWhiteTime(value);
	}
	
	public long getBlackTime() {
		return sCInterface.getBlackTime();
	}
	
	public void setBlackTime(long value) {
		sCInterface.setBlackTime(value);
	}
	
	/* Entry action for state 'Black'. */
	private void entryAction_main_region_Black() {
		timer.setTimer(this, 0, (1 * 1000), false);
	}
	
	/* Entry action for state 'White'. */
	private void entryAction_main_region_White() {
		timer.setTimer(this, 1, (1 * 1000), false);
	}
	
	/* Exit action for state 'Black'. */
	private void exitAction_main_region_Black() {
		timer.unsetTimer(this, 0);
	}
	
	/* Exit action for state 'White'. */
	private void exitAction_main_region_White() {
		timer.unsetTimer(this, 1);
	}
	
	/* 'default' enter sequence for state Init */
	private void enterSequence_main_region_Init_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Init;
	}
	
	/* 'default' enter sequence for state Black */
	private void enterSequence_main_region_Black_default() {
		entryAction_main_region_Black();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Black;
	}
	
	/* 'default' enter sequence for state White */
	private void enterSequence_main_region_White_default() {
		entryAction_main_region_White();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_White;
	}
	
	/* 'default' enter sequence for state trap */
	private void enterSequence_main_region_trap_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_trap;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* Default exit sequence for state Init */
	private void exitSequence_main_region_Init() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Black */
	private void exitSequence_main_region_Black() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Black();
	}
	
	/* Default exit sequence for state White */
	private void exitSequence_main_region_White() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_White();
	}
	
	/* Default exit sequence for state trap */
	private void exitSequence_main_region_trap() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_Init:
			exitSequence_main_region_Init();
			break;
		case main_region_Black:
			exitSequence_main_region_Black();
			break;
		case main_region_White:
			exitSequence_main_region_White();
			break;
		case main_region_trap:
			exitSequence_main_region_trap();
			break;
		default:
			break;
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_Init_default();
	}
	
	private boolean react() {
		return false;
	}
	
	private boolean main_region_Init_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				if (sCInterface.start) {
					exitSequence_main_region_Init();
					enterSequence_main_region_White_default();
				} else {
					did_transition = false;
				}
			}
		}
		return did_transition;
	}
	
	private boolean main_region_Black_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				if (sCInterface.black) {
					exitSequence_main_region_Black();
					enterSequence_main_region_White_default();
				} else {
					if (timeEvents[0]) {
						exitSequence_main_region_Black();
						sCInterface.setBlackTime(sCInterface.getBlackTime() - 1);
						
						enterSequence_main_region_Black_default();
					} else {
						if (sCInterface.trap) {
							exitSequence_main_region_Black();
							enterSequence_main_region_trap_default();
						} else {
							did_transition = false;
						}
					}
				}
			}
		}
		return did_transition;
	}
	
	private boolean main_region_White_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				if (sCInterface.white) {
					exitSequence_main_region_White();
					enterSequence_main_region_Black_default();
				} else {
					if (timeEvents[1]) {
						exitSequence_main_region_White();
						sCInterface.setWhiteTime(sCInterface.getWhiteTime() - 1);
						
						enterSequence_main_region_White_default();
					} else {
						did_transition = false;
					}
				}
			}
		}
		return did_transition;
	}
	
	private boolean main_region_trap_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				did_transition = false;
			}
		}
		return did_transition;
	}
	
}
