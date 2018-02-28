package text;
import java.awt.*;
import javax.swing.*;

import tetris.GameWindow;

import java.util.*;
public class Tetris extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public final static int WIDTH = 320;
	public final static int HEIGHT = 600;
	//方块边长
	public static final int BLOCK_SIZE = 20;
	//窗口横向方块总数
	public static final int WIDTH_NUM = WIDTH / BLOCK_SIZE;		//16
	//窗口竖直方块总数
	public static final int HEIGHT_NUM = HEIGHT / BLOCK_SIZE;	//30
	//代表方块在窗口上的分布情况，0代表空，1代表正在移动的方块，2代表已经固定的方块
	public static int[][] space=new int[HEIGHT_NUM][WIDTH_NUM];
	//七种图形，分别是田字型0、一字型1、正Z型2、反Z型3、正L型4、反L型5、T字型6。每个图形包含4个方块。其中{0,0}为中心点。
	//其中第一个[]代表图形种类、第二个[]为x坐标、第三个[]则为y坐标
	private final int[][][] shapes = {{{-1,0},{0,0},{-1,1},{0,1}},
									  {{-1,0},{0,0},{1,0}, {2,0}}, 
								      {{-1,0},{0,0},{0,1}, {1,1}},
								      {{-1,1},{0,1},{0,0}, {1,0}},
								      {{-1,1},{-1,0},{0,0},{1,0}},
								      {{-1,0},{0,0},{1,0}, {1,1}},
								      {{-1,0},{0,0},{1,0}, {0,1}}};
	//当前正在下落的图形的坐标
	private int[][] currentShape = new int[4][2];
	//画布
	private Canvas canvas = new Canvas();
	//当前中心点的坐标
	private Point centerPos = new Point();
	//选择图形
	private void choseShape() {
		Random rand = new Random(47);
		int index = rand.nextInt(6);
		for(int i=0;i<4;i++) {
			for(int j=0;j<2;j++) {
				currentShape[i][j]=shapes[index][i][j];
			}
		}
		centerPos.x = WIDTH_NUM / 2;
		centerPos.y=0;
		updateSpace(1);
	}
	//更新图形分布
	private void updateSpace(int flag)
	{
		for (int i = 0; i < 4; i++)
		{
			int x = centerPos.x + currentShape[i][0];
			int y = centerPos.y + currentShape[i][1];
			space[y][x] = flag;
		}
	}
	//构造
	Tetris(){
		init();
		add(canvas);
		startGame();
	}
	void init() {
		setTitle("Game");
		setBounds(100,100,WIDTH,HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void startGame()
	{
		choseShape();
	}

	public static void main(String[] args) {
		new Tetris();
	}
}
