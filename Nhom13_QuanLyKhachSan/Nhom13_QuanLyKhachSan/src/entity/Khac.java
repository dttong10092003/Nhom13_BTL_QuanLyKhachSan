/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Time;

/**
 *
 * @author ADMIN
 */
public class Khac {
	private Time checkIn,checkOut;
	private int moc1,moc2,moc3,moc4,phuThu1,phuThu2,phuThu3,phuThu4;

  

    public Time getCheckIn() {
	return checkIn;
}

public void setCheckIn(Time checkIn) {
	this.checkIn = checkIn;
}



    public Time getCheckOut() {
	return checkOut;
}

public void setCheckOut(Time checkOut) {
	this.checkOut = checkOut;
}

	public int getMoc1() {
        return moc1;
    }

    public void setMoc1(int moc1) {
        this.moc1 = moc1;
    }

    public int getMoc2() {
        return moc2;
    }

    public void setMoc2(int moc2) {
        this.moc2 = moc2;
    }

    public int getMoc3() {
        return moc3;
    }

    public void setMoc3(int moc3) {
        this.moc3 = moc3;
    }

    public int getMoc4() {
        return moc4;
    }

    public void setMoc4(int moc4) {
        this.moc4 = moc4;
    }

	public int getPhuThu1() {
		return phuThu1;
	}

	public void setPhuThu1(int phuThu1) {
		this.phuThu1 = phuThu1;
	}

	public int getPhuThu2() {
		return phuThu2;
	}

	public void setPhuThu2(int phuThu2) {
		this.phuThu2 = phuThu2;
	}

	public int getPhuThu3() {
		return phuThu3;
	}

	public void setPhuThu3(int phuThu3) {
		this.phuThu3 = phuThu3;
	}

	public int getPhuThu4() {
		return phuThu4;
	}

	public void setPhuThu4(int phuThu4) {
		this.phuThu4 = phuThu4;
	}

   
}
