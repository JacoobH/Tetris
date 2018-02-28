class Canvas extends JPanel{
  private static final long serialVersionUID = 1L;
  protected void paintComponent(Graphics g){
    super.paintComponent();
    for(int i=0;i<HEIGHT_NUM;i++){
      for(int j=0;j<WIDTH_NUM;j++){
        if(Tetris.space[i][j]!=0)
          g.fillRect(j * BLOCK_SIZE, i * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE)
      }
    }
  }
}
