package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
	public String[] carsList;
	public int numberOfMove;

	public String[] getCarsList() {
		return carsList;
	}

	public int getNumberOfMove() {
		return numberOfMove;
	}

	public void scanCarsList() {
		boolean carsScan = true;
		System.out.println(Constant.CAR_NAME_INPUT);
		while (carsScan) {
			try {
				String carsInput = Console.readLine();
				isValidCars(carsInput);
				carsScan = false;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void scanNumberOfMove() {
		boolean numberScan = true;
		System.out.println(Constant.TRY_NUMBER);
		while (numberScan) {
			try {
				String numberOfMove = Console.readLine();
				isValidNumber(numberOfMove);
				this.numberOfMove = toInt(numberOfMove);
				numberScan = false;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void isValidCars(String carsInput) throws IllegalArgumentException {
		if (carsInput.length() == 0) {
			throw new IllegalArgumentException(Constant.CAR_NAME_ERROR);
		}
		carsList = carsInput.split(",");
		if (carsList.length == 0) {
			throw new IllegalArgumentException(Constant.CAR_NAME_ERROR);
		}
		for (String car : carsList) {
			if (car.length() > Constant.MAXIMUM_NAME_LENGTH) {
				throw new IllegalArgumentException(Constant.CAR_NAME_ERROR);
			}
		}
	}

	public void isValidNumber(String number) throws IllegalArgumentException {
		if (number.length() == 0 || !isNumber(number)) {
			throw new IllegalArgumentException(Constant.TRY_NUMBER_ERROR);
		}
	}

	public boolean isNumber(String number) {
		for (int i = 0; i < number.length(); i++) {
			if (!Character.isDigit((number.charAt(i)))) {
				return false;
			}
		}
		return true;
	}

	public static int toInt(String number) {
		return Integer.parseInt(number);
	}
}
