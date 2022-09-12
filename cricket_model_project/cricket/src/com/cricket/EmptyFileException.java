package com.cricket;

public class EmptyFileException extends Exception{
    EmptyFileException(String path)
    {
        super("The file("+path+") you trying to read is empty");
    }
}
