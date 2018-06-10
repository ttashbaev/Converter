package com.example.timur.converter;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Timur on 17.03.2018.
 */

public class CurrencyModel {

        @SerializedName("base")
        private String base;
        @SerializedName("date")
        private String date;
        @SerializedName("rates")
        private Rates rates;

        public String getBase() {
            return base;
        }

        public void setBase(String base) {
            this.base = base;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Rates getRates() {
            return rates;
        }

        public void setRates(Rates rates) {
            this.rates = rates;
        }

    public class Rates {
        private String AUD;
        private String BGN;
        private String BRL;
        private String CAD;
        private String CHF;
        private String CNY;
        private String CZK;
        private String DKK;
        private String GBP;
        private String HKD;
        private String HRK;
        private String HUF;
        private String IDR;
        private String ILS;
        private String INR;
        private String ISK;
        private String JPY;
        private String KRW;
        private String MXN;
        private String MYR;
        private String NOK;
        private String NZD;
        private String PHP;
        private String PLN;
        private String RON;
        private String RUB;
        private String SEK;
        private String SGD;
        private String THB;
        private String TRY;
        private String USD;
        private String ZAR;

        public String getAUD() {
            return AUD;
        }

        public void setAUD(String AUD) {
            this.AUD = AUD;
        }

        public String getBGN() {
            return BGN;
        }

        public void setBGN(String BGN) {
            this.BGN = BGN;
        }

        public String getBRL() {
            return BRL;
        }

        public void setBRL(String BRL) {
            this.BRL = BRL;
        }

        public String getCAD() {
            return CAD;
        }

        public void setCAD(String CAD) {
            this.CAD = CAD;
        }

        public String getCHF() {
            return CHF;
        }

        public void setCHF(String CHF) {
            this.CHF = CHF;
        }

        public String getCNY() {
            return CNY;
        }

        public void setCNY(String CNY) {
            this.CNY = CNY;
        }

        public String getCZK() {
            return CZK;
        }

        public void setCZK(String CZK) {
            this.CZK = CZK;
        }

        public String getDKK() {
            return DKK;
        }

        public void setDKK(String DKK) {
            this.DKK = DKK;
        }

        public String getGBP() {
            return GBP;
        }

        public void setGBP(String GBP) {
            this.GBP = GBP;
        }

        public String getHKD() {
            return HKD;
        }

        public void setHKD(String HKD) {
            this.HKD = HKD;
        }

        public String getHRK() {
            return HRK;
        }

        public void setHRK(String HRK) {
            this.HRK = HRK;
        }

        public String getHUF() {
            return HUF;
        }

        public void setHUF(String HUF) {
            this.HUF = HUF;
        }

        public String getIDR() {
            return IDR;
        }

        public void setIDR(String IDR) {
            this.IDR = IDR;
        }

        public String getILS() {
            return ILS;
        }

        public void setILS(String ILS) {
            this.ILS = ILS;
        }

        public String getINR() {
            return INR;
        }

        public void setINR(String INR) {
            this.INR = INR;
        }

        public String getISK() {
            return ISK;
        }

        public void setISK(String ISK) {
            this.ISK = ISK;
        }

        public String getJPY() {
            return JPY;
        }

        public void setJPY(String JPY) {
            this.JPY = JPY;
        }

        public String getKRW() {
            return KRW;
        }

        public void setKRW(String KRW) {
            this.KRW = KRW;
        }

        public String getMXN() {
            return MXN;
        }

        public void setMXN(String MXN) {
            this.MXN = MXN;
        }

        public String getMYR() {
            return MYR;
        }

        public void setMYR(String MYR) {
            this.MYR = MYR;
        }

        public String getNOK() {
            return NOK;
        }

        public void setNOK(String NOK) {
            this.NOK = NOK;
        }

        public String getNZD() {
            return NZD;
        }

        public void setNZD(String NZD) {
            this.NZD = NZD;
        }

        public String getPHP() {
            return PHP;
        }

        public void setPHP(String PHP) {
            this.PHP = PHP;
        }

        public String getPLN() {
            return PLN;
        }

        public void setPLN(String PLN) {
            this.PLN = PLN;
        }

        public String getRON() {
            return RON;
        }

        public void setRON(String RON) {
            this.RON = RON;
        }

        public String getRUB() {
            return RUB;
        }

        public void setRUB(String RUB) {
            this.RUB = RUB;
        }

        public String getSEK() {
            return SEK;
        }

        public void setSEK(String SEK) {
            this.SEK = SEK;
        }

        public String getSGD() {
            return SGD;
        }

        public void setSGD(String SGD) {
            this.SGD = SGD;
        }

        public String getTHB() {
            return THB;
        }

        public void setTHB(String THB) {
            this.THB = THB;
        }

        public String getTRY() {
            return TRY;
        }

        public void setTRY(String TRY) {
            this.TRY = TRY;
        }

        public String getUSD() {
            return USD;
        }

        public void setUSD(String USD) {
            this.USD = USD;
        }

        public String getZAR() {
            return ZAR;
        }

        public void setZAR(String ZAR) {
            this.ZAR = ZAR;
        }
    }


}

