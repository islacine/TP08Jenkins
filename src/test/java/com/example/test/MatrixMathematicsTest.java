package com.example.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.exception.NoSquareException;
import com.example.model.Matrix;
import com.example.service.MatrixMathematics;

public class MatrixMathematicsTest {
/*
	@Test
	public void testTranspose() {
		int i;
		double [][] data1= {{1,2},{3,4},{5,6}};
		Matrix mat1=new Matrix(data1);
		double [][] data2= {{1,3,5},{2,4,6}};
		Matrix mat2=new Matrix(data2);
		Matrix matTrans=MatrixMathematics.transpose(mat1);
		for(i=0;i<matTrans.getValues().length;i++)
		{
			assertArrayEquals(matTrans.getValues()[i],mat2.getValues()[i],0);
		}
			
	}
**/
/**	@Test
	public void testInverse() throws NoSquareException {
		int i;
		double [][] data1= {{2,2,3},{4,5,4},{7,8,9}};
		Matrix mat1=new Matrix(data1);
		double [][] data2= {{13,6,-7},{-8,-3,4},{-3,-2,2}};
		Matrix mat2=new Matrix(data2);
		Matrix matTrans=MatrixMathematics.inverse(mat1);
		for(i=0;i<matTrans.getValues().length;i++)
		{
			assertArrayEquals(matTrans.getValues()[i],mat2.getValues()[i],0);
		}
			
	}

	**/
	@Test(expected = NoSquareException.class)
	public void testNoSquareException() throws NoSquareException {
		int i;
		double [][] data1= {{1,0,0},{0,0,1}};
		Matrix mat1=new Matrix(data1);
		double [][] data2= {{1/6,-1/3,1/6},{-1/3,-7/3,5/3}};
		Matrix mat2=new Matrix(data2);
		//Matrix matTrans=MatrixMathematics.inverse(mat1);
		double matTrans=MatrixMathematics.determinant(mat1);


	}
	@Test
	public void testDeterminant() throws NoSquareException {
		int i;
		double [][] data1= {{1,2,3},{4,9,6},{7,8,9}};
		double determin=-48;
		Matrix mat1=new Matrix(data1);
		assertEquals(MatrixMathematics.determinant(mat1),determin,0);
		
	}
/*Avant le coverage*/
	@Test
	public void testCreateSubMatrix() {
		int i;
		double [][] data1= {{1,2,3},{4,5,6},{7,8,9}};
		Matrix mat1=new Matrix(data1);
		double [][] data2= {{4,6},{7,9}};
		Matrix mat2=new Matrix(data2);
		Matrix matSub=MatrixMathematics.createSubMatrix(mat1, 0, 1);
		for(i=0;i<matSub.getValues().length;i++)
		{
			assertArrayEquals(matSub.getValues()[i],mat2.getValues()[i],0);
		}
		
	}

	@Test
	public void testCofactor() throws NoSquareException {
		int i;
		double [][] data1= {{1,2,3},{4,5,6},{7,8,9}};
		Matrix mat1=new Matrix(data1);
		double [][] data2= {{-3,6,-3},{6,-12,6},{-3,6,-3}};
		Matrix mat2=new Matrix(data2);
		Matrix matCofact=MatrixMathematics.cofactor(mat1);
		for(i=0;i<matCofact.getValues().length;i++)
		{
			assertArrayEquals(matCofact.getValues()[i],mat2.getValues()[i],0);
		}
	}

}
