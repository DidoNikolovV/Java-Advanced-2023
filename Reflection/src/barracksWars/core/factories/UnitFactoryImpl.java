package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
		Class<?> unitTypeClass;
		try {
			unitTypeClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<?> constructor = unitTypeClass.getConstructor();
			return (Unit) constructor.newInstance();
		}catch(ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException |
			   InstantiationException e) {
			throw new IllegalStateException(e);
		}
	}
}
