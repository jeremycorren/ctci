#### Java

_Objects_ model state as one or more attribute fields, and implement behavior with methods that mutate state.

Objects are defined by a _class_, or a blueprint to which instances conform. We usually design classes according to user expectations, than service with different implementations for different needs:
```java
interface HasSwitch {
	void flipSwitch();
}

//Must implement `switch`
class Device implements HasSwitch {
	boolean on = false;
	void flipSwitch() {
		on = !on;
	}
}
```

Thanks to _inheritance_, we can subclass derivative classes to reuse or override common code:
```java
class Synth extends Device {
	int volume = 0;
	void adjustVolume(int db) {
		volume += db;
	}

	@Override void flipSwitch() {
		if (volume == 0) volume = 50;
		super.flipSwitch();
	}

	public static void main(String[] args) {
		Synth synth = new Synth();
		synth.flipSwitch();
		synth.adjustVolume(10);
	}
}
```
Object references, such as those to `synth`, are garbage collected automatically when program exits the scope in which a reference was declared and instantiated.

