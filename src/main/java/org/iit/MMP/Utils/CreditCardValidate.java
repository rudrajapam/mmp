package org.iit.MMP.Utils;

public class CreditCardValidate {

	public boolean creditCardNoCheck(String cCardNo) {

		int total = 0;
		if (cCardNo.length() < 15 || cCardNo.length() > 16) {
			System.out.println("Please check your card number");
		}

		// creating an integer array for storing the cc no.
		int[] cardnumberChk = new int[cCardNo.length()];

		for (int i = 0; i < cCardNo.length(); i++) {
			cardnumberChk[i] = Integer.parseInt(cCardNo.substring(i, i + 1));
		}

		// looping thr each digit of the cc no
		for (int i = cardnumberChk.length - 2; i >= 0; i = i - 2) {
			int temp = cardnumberChk[i];
			temp = temp * 2;

			if (temp > 9) {
				temp = temp % 10 + 1;
			}
			cardnumberChk[i] = temp;
		}

		for (int j = 0; j < cardnumberChk.length; j++) {

			total = total + cardnumberChk[j];
		}

		if (total % 10 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean CustName(String custName) {

		if (custName != null && custName.matches("^[A-za-z \']*$")) {
			System.out.println("valid name");
			return true;
		}
		return false;
	}

}
