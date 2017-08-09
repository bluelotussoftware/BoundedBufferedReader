package com.seantmalone.io;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Example Usage of the BoundedBufferedReader class
 *
 * Copyright (c) 2011 - Sean Malone
 *
 * The BoundedBufferedReader is published by Sean Malone under the BSD license.
 * You should read and accept the LICENSE before you use, modify, and/or
 * redistribute this software.
 *
 * @author Sean Malone <sean@seantmalone.com>
 * @version 1.1
 */
public class ExampleUsage {

    public static void main(String args[]) {

        Integer maxLines = 1024;
        Integer maxLineLen = 1024;

        if (args.length >= 1) {
            maxLines = Integer.parseInt(args[0]);
        }
        if (args.length >= 2) {
            maxLineLen = Integer.parseInt(args[1]);
        }

        try (FileReader fReader = new FileReader("TestCase.txt");
                BoundedBufferedReader bbReader = new BoundedBufferedReader(fReader, maxLines, maxLineLen);
                FileWriter fWriter = new FileWriter("TestCase_output.txt");
                BufferedWriter bWriter = new BufferedWriter(fWriter);) {

            String line;
            while ((line = bbReader.readLine()) != null) {
                System.out.println(line);
                bWriter.write(line);
                bWriter.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
