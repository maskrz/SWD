/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Skrzypek
 */
public class StraightDistanceTable {

    private double[][] straightDistances;
    private int pointsAmount;

    public StraightDistanceTable(int pointsAmount, String csv) {
        this.pointsAmount = pointsAmount;
        straightDistances = new double[pointsAmount][pointsAmount];
        if (csv == null) {
            csv = createPolishMap();
        }
        fillTable(csv);
    }

    public StraightDistanceTable() {
        this(16, null);
    }

    private void fillTable(String csv) {
        try {
            InputStream inputStream = createStreamFromString(csv);
            BufferedReader bufferedReader = createBRFromIS(inputStream);
            String line;
            for (int i = 0; i < pointsAmount; i ++) {
                line = bufferedReader.readLine();
                fillRow(line, i);
            }
        } catch (IOException ex) {
            Logger.getLogger(StraightDistanceTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private InputStream createStreamFromString(String csv) {
        return new ByteArrayInputStream(csv.getBytes());
    }

    private BufferedReader createBRFromIS(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream));
    }

    private String createPolishMap() {
        return "x;237.5;386;140.5;183;236;301.5;78.5;370;475.5;277;168.5;253;378;145;309\n"
                + ";x;335;241.5;151.5;341.5;185;264.5;406;306;149;307.5;276.5;151;131.5;273.5\n"
                + ";;x;494;223;227;153.5;332;140;214;435;272.5;142;315.5;409;596.5\n"
                + ";;;x;272.5;374;378;219;501.5;535.5;341;308.5;375;292;110;178\n"
                + ";;;;x;191.5;119;161.5;261.5;294.5;293.5;169;128.5;235;187.5;380\n"
                + ";;;;;x;252.5;159;147;407.5;485.5;69.5;101.5;415;335;527.5\n"
                + ";;;;;;x;275.5;253;177;284;259;154;176;279;454.5\n"
                + ";;;;;;;x;298;452.5;412.5;90.5;192;387;204.5;383.5\n"
                + ";;;;;;;;x;353.5;351.5;213.5;133.5;429;441;636.5\n"
                + ";;;;;;;;;x;327;428.5;306.5;192;428;574\n"
                + ";;;;;;;;;;x;456;410.5;135.5;245;287.5\n"
                + ";;;;;;;;;;;x;131.5;403.5;279.5;467.5\n"
                + ";;;;;;;;;;;;x;324.5;308;503.5\n"
                + ";;;;;;;;;;;;;x;282.5;393.5\n"
                + ";;;;;;;;;;;;;;x;195.5\n"
                + ";;;;;;;;;;;;;;;x";
    }

    private void fillRow(String line, int rowNumber) {
        String[] distances = line.split(";");
        for(int i = 0; i < pointsAmount; i ++) {
            String value = distances[i];
            if(!("x".equals(value) || "".equals(value))){
                double distance = Double.valueOf(value);
                straightDistances[rowNumber][i] = distance;
                straightDistances[i][rowNumber] = distance;
            }
        }
    }

    public double getDistanceBeetwenPoints(int pointA, int pointB) {
        return straightDistances[pointA][pointB];
    }

}
