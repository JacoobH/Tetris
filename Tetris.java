package text;
import java.awt.*;
import javax.swing.*;

import tetris.GameWindow;

import java.util.*;
public class Tetris extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public final static int WIDTH = 320;
	public final static int HEIGHT = 600;
	//����߳�
	public static final int BLOCK_SIZE = 20;
	//���ں��򷽿�����
	public static final int WIDTH_NUM = WIDTH / BLOCK_SIZE;		//16
	//������ֱ��������
	public static final int HEIGHT_NUM = HEIGHT / BLOCK_SIZE;	//30
	//�������ڴ����ϵķֲ������0����գ�1���������ƶ��ķ��飬2�����Ѿ��̶��ķ���
	public static int[][] space=new int[HEIGHT_NUM][WIDTH_NUM];
	//����ͼ�Σ��ֱ���������0��һ����1����Z��2����Z��3����L��4����L��5��T����6��ÿ��ͼ�ΰ���4�����顣����{0,0}Ϊ���ĵ㡣
	//���е�һ��[]����ͼ�����ࡢ�ڶ���[]Ϊx���ꡢ������[]��Ϊy����
	private final int[][][] shapes = {{{-1,0},{0,0},{-1,1},{0,1}},
									  {{-1,0},{0,0},{1,0}, {2,0}}, 
								      {{-1,0},{0,0},{0,1}, {1,1}},
								      {{-1,1},{0,1},{0,0}, {1,0}},
								      {{-1,1},{-1,0},{0,0},{1,0}},
								      {{-1,0},{0,0},{1,0}, {1,1}},
								      {{-1,0},{0,0},{1,0}, {0,1}}};
	//��ǰ���������ͼ�ε�����
	private int[][] currentShape = new int[4][2];
	//ѡ��ͼ��
	private void choseShape() {
		Random rand = new Random(47);
		int index = rand.nextInt(6);
		for(int i=0;i<4;i++) {
			for(int j=0;j<2;j++) {
				currentShape[i][j]=shapes[index][i][j];
			}
		}
	}
	Tetris(){
		init();
		
	}
	void init() {
		setTitle("Game");
		setBounds(100,100,WIDTH,HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//���ͼ��
		//add();
		setVisible(true);
	}

	public static void main(String[] args) {
		new Tetris();
	}
}
