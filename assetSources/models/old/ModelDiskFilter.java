// Date: 11-Aug-13 1:28:54 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package net.minecraft.src;

public class ModelModel extends ModelBase
{
  //fields
    ModelRenderer SupportBeamTop;
    ModelRenderer SupportBeamRightBottom;
    ModelRenderer SupportBeamLeftBottom;
    ModelRenderer WallRight;
    ModelRenderer WallLeft;
    ModelRenderer BottomPlate;
    ModelRenderer SupportBeamLeftFront;
    ModelRenderer SupportBeamRightFront;
    ModelRenderer SupportBeamLeftBack;
    ModelRenderer SupportBeamRightBack;
    ModelRenderer BottomPipe;
    ModelRenderer WaterInput;
    ModelRenderer PowerInput;
    ModelRenderer ChunksInput;
    ModelRenderer MixedOutput;
    ModelRenderer Geul1;
    ModelRenderer Geul2;
    ModelRenderer Geul3;
    ModelRenderer Geul4;
    ModelRenderer Geul5;
    ModelRenderer Geul6;
    ModelRenderer Geul7;
    ModelRenderer Geul8;
    ModelRenderer Geul9;
    ModelRenderer Geul10;
    ModelRenderer Geul11;
    ModelRenderer Geul12;
    ModelRenderer as;
    ModelRenderer as4Back3;
    ModelRenderer as3Back3;
    ModelRenderer as2Back3;
    ModelRenderer as4Back2;
    ModelRenderer as3Back2;
    ModelRenderer as2Back2;
    ModelRenderer as1Back3;
    ModelRenderer as1Back2;
    ModelRenderer as4Front3;
    ModelRenderer as3Front3;
    ModelRenderer as2Front3;
    ModelRenderer as4Front2;
    ModelRenderer as3Front2;
    ModelRenderer as2Front2;
    ModelRenderer as1Front3;
    ModelRenderer as1middel;
    ModelRenderer as2middel;
    ModelRenderer as3middel;
    ModelRenderer as4middel;
    ModelRenderer as1Back1;
    ModelRenderer as1Front1;
    ModelRenderer as2Front1;
    ModelRenderer as3Front1;
    ModelRenderer as4Front1;
    ModelRenderer as2Back1;
    ModelRenderer as4Back1;
    ModelRenderer as3Back1;
    ModelRenderer as1Front2;
    ModelRenderer Glider;
    ModelRenderer OreBar;
    ModelRenderer BottomPlate2;
  
  public ModelModel()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      SupportBeamTop = new ModelRenderer(this, 0, 11);
      SupportBeamTop.addBox(0F, 0F, -6.5F, 16, 1, 13);
      SupportBeamTop.setRotationPoint(-8F, 8.5F, 0F);
      SupportBeamTop.setTextureSize(64, 32);
      SupportBeamTop.mirror = true;
      setRotation(SupportBeamTop, 0F, 0F, 0F);
      SupportBeamRightBottom = new ModelRenderer(this, 0, 2);
      SupportBeamRightBottom.addBox(0F, 0F, 0F, 16, 2, 4);
      SupportBeamRightBottom.setRotationPoint(-8F, 22F, -8F);
      SupportBeamRightBottom.setTextureSize(64, 32);
      SupportBeamRightBottom.mirror = true;
      setRotation(SupportBeamRightBottom, 0F, 0F, 0F);
      SupportBeamLeftBottom = new ModelRenderer(this, 0, 2);
      SupportBeamLeftBottom.addBox(0F, 0F, 0F, 16, 2, 4);
      SupportBeamLeftBottom.setRotationPoint(-8F, 22F, 4F);
      SupportBeamLeftBottom.setTextureSize(64, 32);
      SupportBeamLeftBottom.mirror = true;
      setRotation(SupportBeamLeftBottom, 0F, 0F, 0F);
      WallRight = new ModelRenderer(this, 36, 37);
      WallRight.addBox(0F, 0F, 0F, 1, 13, 12);
      WallRight.setRotationPoint(-7F, 9F, -6F);
      WallRight.setTextureSize(64, 32);
      WallRight.mirror = true;
      setRotation(WallRight, 0F, 0F, 0F);
      WallLeft = new ModelRenderer(this, 36, 37);
      WallLeft.addBox(0F, 0F, 0F, 1, 13, 12);
      WallLeft.setRotationPoint(6F, 9F, -6F);
      WallLeft.setTextureSize(64, 32);
      WallLeft.mirror = true;
      setRotation(WallLeft, 0F, 0F, 0F);
      BottomPlate = new ModelRenderer(this, 0, 32);
      BottomPlate.addBox(0F, 0F, 0F, 12, 2, 12);
      BottomPlate.setRotationPoint(-6F, 19F, -6F);
      BottomPlate.setTextureSize(64, 32);
      BottomPlate.mirror = true;
      setRotation(BottomPlate, 0F, 0F, 0F);
      SupportBeamLeftFront = new ModelRenderer(this, 44, 29);
      SupportBeamLeftFront.addBox(0F, 0F, 0F, 1, 14, 1);
      SupportBeamLeftFront.setRotationPoint(7F, 8F, -6F);
      SupportBeamLeftFront.setTextureSize(64, 32);
      SupportBeamLeftFront.mirror = true;
      setRotation(SupportBeamLeftFront, 0F, 0F, 0F);
      SupportBeamRightFront = new ModelRenderer(this, 44, 28);
      SupportBeamRightFront.addBox(0F, 0F, 0F, 1, 14, 1);
      SupportBeamRightFront.setRotationPoint(-8F, 8F, -6F);
      SupportBeamRightFront.setTextureSize(64, 32);
      SupportBeamRightFront.mirror = true;
      setRotation(SupportBeamRightFront, 0F, 0F, 0F);
      SupportBeamLeftBack = new ModelRenderer(this, 44, 29);
      SupportBeamLeftBack.addBox(0F, 0F, 0F, 1, 14, 1);
      SupportBeamLeftBack.setRotationPoint(7F, 8F, 5F);
      SupportBeamLeftBack.setTextureSize(64, 32);
      SupportBeamLeftBack.mirror = true;
      setRotation(SupportBeamLeftBack, 0F, 0F, 0F);
      SupportBeamRightBack = new ModelRenderer(this, 44, 29);
      SupportBeamRightBack.addBox(0F, 0F, 0F, 1, 14, 1);
      SupportBeamRightBack.setRotationPoint(-8F, 8F, 5F);
      SupportBeamRightBack.setTextureSize(64, 32);
      SupportBeamRightBack.mirror = true;
      setRotation(SupportBeamRightBack, 0F, 0F, 0F);
      BottomPipe = new ModelRenderer(this, 24, 26);
      BottomPipe.addBox(0F, 0F, 0F, 4, 2, 4);
      BottomPipe.setRotationPoint(-2F, 21F, -2F);
      BottomPipe.setTextureSize(64, 32);
      BottomPipe.mirror = true;
      setRotation(BottomPipe, 0F, 0F, 0F);
      WaterInput = new ModelRenderer(this, 50, 37);
      WaterInput.addBox(0F, 0F, 0F, 1, 6, 6);
      WaterInput.setRotationPoint(7F, 13F, -3F);
      WaterInput.setTextureSize(64, 32);
      WaterInput.mirror = true;
      setRotation(WaterInput, 0F, 0F, 0F);
      PowerInput = new ModelRenderer(this, 50, 37);
      PowerInput.addBox(0F, 0F, 0F, 1, 6, 6);
      PowerInput.setRotationPoint(-8F, 13F, -3F);
      PowerInput.setTextureSize(64, 32);
      PowerInput.mirror = true;
      setRotation(PowerInput, 0F, 0F, 0F);
      ChunksInput = new ModelRenderer(this, 0, 25);
      ChunksInput.addBox(0F, 0F, 0F, 6, 1, 6);
      ChunksInput.setRotationPoint(-3F, 8F, -3F);
      ChunksInput.setTextureSize(64, 32);
      ChunksInput.mirror = true;
      setRotation(ChunksInput, 0F, 0F, 0F);
      MixedOutput = new ModelRenderer(this, 0, 25);
      MixedOutput.addBox(0F, 0F, 0F, 6, 1, 6);
      MixedOutput.setRotationPoint(-3F, 23F, -3F);
      MixedOutput.setTextureSize(64, 32);
      MixedOutput.mirror = true;
      setRotation(MixedOutput, 0F, 0F, 0F);
      Geul1 = new ModelRenderer(this, 0, 61);
      Geul1.addBox(0F, 0F, 0F, 12, 1, 0);
      Geul1.setRotationPoint(-6F, 18F, 2F);
      Geul1.setTextureSize(64, 32);
      Geul1.mirror = true;
      setRotation(Geul1, 0F, 0F, 0F);
      Geul2 = new ModelRenderer(this, 0, 48);
      Geul2.addBox(0F, 0F, 0F, 0, 1, 12);
      Geul2.setRotationPoint(-4F, 18F, -6F);
      Geul2.setTextureSize(64, 32);
      Geul2.mirror = true;
      setRotation(Geul2, 0F, 0F, 0F);
      Geul3 = new ModelRenderer(this, 0, 61);
      Geul3.addBox(0F, 0F, 0F, 12, 1, 0);
      Geul3.setRotationPoint(-6F, 18F, -1F);
      Geul3.setTextureSize(64, 32);
      Geul3.mirror = true;
      setRotation(Geul3, 0F, 0F, 0F);
      Geul4 = new ModelRenderer(this, 0, 48);
      Geul4.addBox(0F, 0F, 0F, 0, 1, 12);
      Geul4.setRotationPoint(-5F, 18F, -6F);
      Geul4.setTextureSize(64, 32);
      Geul4.mirror = true;
      setRotation(Geul4, 0F, 0F, 0F);
      Geul5 = new ModelRenderer(this, 0, 48);
      Geul5.addBox(0F, 0F, 0F, 0, 1, 12);
      Geul5.setRotationPoint(-2F, 18F, -6F);
      Geul5.setTextureSize(64, 32);
      Geul5.mirror = true;
      setRotation(Geul5, 0F, 0F, 0F);
      Geul6 = new ModelRenderer(this, 0, 48);
      Geul6.addBox(0F, 0F, 0F, 0, 1, 12);
      Geul6.setRotationPoint(-1F, 18F, -6F);
      Geul6.setTextureSize(64, 32);
      Geul6.mirror = true;
      setRotation(Geul6, 0F, 0F, 0F);
      Geul7 = new ModelRenderer(this, 0, 48);
      Geul7.addBox(0F, 0F, 0F, 0, 1, 12);
      Geul7.setRotationPoint(1F, 18F, -6F);
      Geul7.setTextureSize(64, 32);
      Geul7.mirror = true;
      setRotation(Geul7, 0F, 0F, 0F);
      Geul8 = new ModelRenderer(this, 0, 48);
      Geul8.addBox(0F, 0F, 0F, 0, 1, 12);
      Geul8.setRotationPoint(2F, 18F, -6F);
      Geul8.setTextureSize(64, 32);
      Geul8.mirror = true;
      setRotation(Geul8, 0F, 0F, 0F);
      Geul9 = new ModelRenderer(this, 0, 48);
      Geul9.addBox(0F, 0F, 0F, 0, 1, 12);
      Geul9.setRotationPoint(4F, 18F, -6F);
      Geul9.setTextureSize(64, 32);
      Geul9.mirror = true;
      setRotation(Geul9, 0F, 0F, 0F);
      Geul10 = new ModelRenderer(this, 0, 48);
      Geul10.addBox(0F, 0F, 0F, 0, 1, 12);
      Geul10.setRotationPoint(5F, 18F, -6F);
      Geul10.setTextureSize(64, 32);
      Geul10.mirror = true;
      setRotation(Geul10, 0F, 0F, 0F);
      Geul11 = new ModelRenderer(this, 1, 61);
      Geul11.addBox(0F, 0F, 0F, 10, 1, 0);
      Geul11.setRotationPoint(-5F, 18F, -6F);
      Geul11.setTextureSize(64, 32);
      Geul11.mirror = true;
      setRotation(Geul11, 0F, 0F, 0F);
      Geul12 = new ModelRenderer(this, 1, 61);
      Geul12.addBox(0F, 0F, 0F, 10, 1, 0);
      Geul12.setRotationPoint(-5F, 18F, 6F);
      Geul12.setTextureSize(64, 32);
      Geul12.mirror = true;
      setRotation(Geul12, 0F, 0F, 0F);
      as = new ModelRenderer(this, 0, 0);
      as.addBox(-6F, -0.5F, -0.5F, 12, 1, 1);
      as.setRotationPoint(0F, 13.5F, 0.5F);
      as.setTextureSize(64, 32);
      as.mirror = true;
      setRotation(as, 0F, 0F, 0F);
      as4Back3 = new ModelRenderer(this, 5, 20);
      as4Back3.addBox(-0.5F, -1.5F, 2.5F, 1, 3, 1);
      as4Back3.setRotationPoint(4.5F, 13.5F, 0.5F);
      as4Back3.setTextureSize(64, 32);
      as4Back3.mirror = true;
      setRotation(as4Back3, 0F, 0F, 0F);
      as3Back3 = new ModelRenderer(this, 5, 20);
      as3Back3.addBox(-0.5F, -1.5F, 2.5F, 1, 3, 1);
      as3Back3.setRotationPoint(1.5F, 13.5F, 0.5F);
      as3Back3.setTextureSize(64, 32);
      as3Back3.mirror = true;
      setRotation(as3Back3, 0F, 0F, 0F);
      as2Back3 = new ModelRenderer(this, 5, 20);
      as2Back3.addBox(-0.5F, -1.5F, 2.5F, 1, 3, 1);
      as2Back3.setRotationPoint(-1.5F, 13.5F, 0.5F);
      as2Back3.setTextureSize(64, 32);
      as2Back3.mirror = true;
      setRotation(as2Back3, 0F, 0F, 0F);
      as4Back2 = new ModelRenderer(this, 9, 18);
      as4Back2.addBox(-0.5F, -2.5F, 1.5F, 1, 5, 1);
      as4Back2.setRotationPoint(4.5F, 13.5F, 0.5F);
      as4Back2.setTextureSize(64, 32);
      as4Back2.mirror = true;
      setRotation(as4Back2, 0F, 0F, 0F);
      as3Back2 = new ModelRenderer(this, 9, 18);
      as3Back2.addBox(-0.5F, -2.5F, 1.5F, 1, 5, 1);
      as3Back2.setRotationPoint(1.5F, 13.5F, 0.5F);
      as3Back2.setTextureSize(64, 32);
      as3Back2.mirror = true;
      setRotation(as3Back2, 0F, 0F, 0F);
      as2Back2 = new ModelRenderer(this, 9, 18);
      as2Back2.addBox(-0.5F, -2.5F, 1.5F, 1, 5, 1);
      as2Back2.setRotationPoint(-1.5F, 13.5F, 0.5F);
      as2Back2.setTextureSize(64, 32);
      as2Back2.mirror = true;
      setRotation(as2Back2, 0F, 0F, 0F);
      as1Back3 = new ModelRenderer(this, 5, 20);
      as1Back3.addBox(-0.5F, -1.5F, 2.5F, 1, 3, 1);
      as1Back3.setRotationPoint(-4.5F, 13.5F, 0.5F);
      as1Back3.setTextureSize(64, 32);
      as1Back3.mirror = true;
      setRotation(as1Back3, 0F, 0F, 0F);
      as1Back2 = new ModelRenderer(this, 9, 18);
      as1Back2.addBox(-0.5F, -2.5F, 1.5F, 1, 5, 1);
      as1Back2.setRotationPoint(-4.5F, 13.5F, 0.5F);
      as1Back2.setTextureSize(64, 32);
      as1Back2.mirror = true;
      setRotation(as1Back2, 0F, 0F, 0F);
      as4Front3 = new ModelRenderer(this, 5, 20);
      as4Front3.addBox(-0.5F, -1.5F, -3.5F, 1, 3, 1);
      as4Front3.setRotationPoint(4.5F, 13.5F, 0.5F);
      as4Front3.setTextureSize(64, 32);
      as4Front3.mirror = true;
      setRotation(as4Front3, 0F, 0F, 0F);
      as3Front3 = new ModelRenderer(this, 5, 20);
      as3Front3.addBox(-0.5F, -1.5F, -3.5F, 1, 3, 1);
      as3Front3.setRotationPoint(1.5F, 13.5F, 0.5F);
      as3Front3.setTextureSize(64, 32);
      as3Front3.mirror = true;
      setRotation(as3Front3, 0F, 0F, 0F);
      as2Front3 = new ModelRenderer(this, 5, 20);
      as2Front3.addBox(-0.5F, -1.5F, -3.5F, 1, 3, 1);
      as2Front3.setRotationPoint(-1.5F, 13.5F, 0.5F);
      as2Front3.setTextureSize(64, 32);
      as2Front3.mirror = true;
      setRotation(as2Front3, 0F, 0F, 0F);
      as4Front2 = new ModelRenderer(this, 9, 18);
      as4Front2.addBox(-0.5F, -2.5F, -2.5F, 1, 5, 1);
      as4Front2.setRotationPoint(4.5F, 13.5F, 0.5F);
      as4Front2.setTextureSize(64, 32);
      as4Front2.mirror = true;
      setRotation(as4Front2, 0F, 0F, 0F);
      as3Front2 = new ModelRenderer(this, 9, 18);
      as3Front2.addBox(-0.5F, -2.5F, -2.5F, 1, 5, 1);
      as3Front2.setRotationPoint(1.5F, 13.5F, 0.5F);
      as3Front2.setTextureSize(64, 32);
      as3Front2.mirror = true;
      setRotation(as3Front2, 0F, 0F, 0F);
      as2Front2 = new ModelRenderer(this, 9, 18);
      as2Front2.addBox(-0.5F, -2.5F, -2.5F, 1, 5, 1);
      as2Front2.setRotationPoint(-1.5F, 13.5F, 0.5F);
      as2Front2.setTextureSize(64, 32);
      as2Front2.mirror = true;
      setRotation(as2Front2, 0F, 0F, 0F);
      as1Front3 = new ModelRenderer(this, 5, 20);
      as1Front3.addBox(-0.5F, -1.5F, -3.5F, 1, 3, 1);
      as1Front3.setRotationPoint(-4.5F, 13.5F, 0.5F);
      as1Front3.setTextureSize(64, 32);
      as1Front3.mirror = true;
      setRotation(as1Front3, 0F, 0F, 0F);
      as1middel = new ModelRenderer(this, 5, 12);
      as1middel.addBox(-0.5F, -3.5F, -0.5F, 1, 7, 1);
      as1middel.setRotationPoint(-4.5F, 13.5F, 0.5F);
      as1middel.setTextureSize(64, 32);
      as1middel.mirror = true;
      setRotation(as1middel, 0F, 0F, 0F);
      as2middel = new ModelRenderer(this, 5, 12);
      as2middel.addBox(-0.5F, -3.5F, -0.5F, 1, 7, 1);
      as2middel.setRotationPoint(-1.5F, 13.5F, 0.5F);
      as2middel.setTextureSize(64, 32);
      as2middel.mirror = true;
      setRotation(as2middel, 0F, 0F, 0F);
      as3middel = new ModelRenderer(this, 5, 12);
      as3middel.addBox(-0.5F, -3.5F, -0.5F, 1, 7, 1);
      as3middel.setRotationPoint(1.5F, 13.5F, 0.5F);
      as3middel.setTextureSize(64, 32);
      as3middel.mirror = true;
      setRotation(as3middel, 0F, 0F, 0F);
      as4middel = new ModelRenderer(this, 5, 12);
      as4middel.addBox(-0.5F, -3.5F, -0.5F, 1, 7, 1);
      as4middel.setRotationPoint(4.5F, 13.5F, 0.5F);
      as4middel.setTextureSize(64, 32);
      as4middel.mirror = true;
      setRotation(as4middel, 0F, 0F, 0F);
      as1Back1 = new ModelRenderer(this, 0, 16);
      as1Back1.addBox(-0.5F, -3.5F, 0.5F, 1, 7, 1);
      as1Back1.setRotationPoint(-4.5F, 13.5F, 0.5F);
      as1Back1.setTextureSize(64, 32);
      as1Back1.mirror = true;
      setRotation(as1Back1, 0F, 0F, 0F);
      as1Front1 = new ModelRenderer(this, 0, 16);
      as1Front1.addBox(-0.5F, -3.5F, -1.5F, 1, 7, 1);
      as1Front1.setRotationPoint(-4.5F, 13.5F, 0.5F);
      as1Front1.setTextureSize(64, 32);
      as1Front1.mirror = true;
      setRotation(as1Front1, 0F, 0F, 0F);
      as2Front1 = new ModelRenderer(this, 0, 16);
      as2Front1.addBox(-0.5F, -3.5F, -1.5F, 1, 7, 1);
      as2Front1.setRotationPoint(-1.5F, 13.5F, 0.5F);
      as2Front1.setTextureSize(64, 32);
      as2Front1.mirror = true;
      setRotation(as2Front1, 0F, 0F, 0F);
      as3Front1 = new ModelRenderer(this, 0, 16);
      as3Front1.addBox(-0.5F, -3.5F, -1.5F, 1, 7, 1);
      as3Front1.setRotationPoint(1.5F, 13.5F, 0.5F);
      as3Front1.setTextureSize(64, 32);
      as3Front1.mirror = true;
      setRotation(as3Front1, 0F, 0F, 0F);
      as4Front1 = new ModelRenderer(this, 0, 16);
      as4Front1.addBox(-0.5F, -2.5F, -1.5F, 1, 7, 1);
      as4Front1.setRotationPoint(4.5F, 12.5F, 0.5F);
      as4Front1.setTextureSize(64, 32);
      as4Front1.mirror = true;
      setRotation(as4Front1, 0F, 0F, 0F);
      as2Back1 = new ModelRenderer(this, 0, 16);
      as2Back1.addBox(-0.5F, -3.5F, 0.5F, 1, 7, 1);
      as2Back1.setRotationPoint(-1.5F, 13.5F, 0.5F);
      as2Back1.setTextureSize(64, 32);
      as2Back1.mirror = true;
      setRotation(as2Back1, 0F, 0F, 0F);
      as4Back1 = new ModelRenderer(this, 0, 16);
      as4Back1.addBox(-0.5F, -3.5F, 0.5F, 1, 7, 1);
      as4Back1.setRotationPoint(4.5F, 13.5F, 0.5F);
      as4Back1.setTextureSize(64, 32);
      as4Back1.mirror = true;
      setRotation(as4Back1, 0F, 0F, 0F);
      as3Back1 = new ModelRenderer(this, 0, 16);
      as3Back1.addBox(-0.5F, -3.5F, 0.5F, 1, 7, 1);
      as3Back1.setRotationPoint(1.5F, 13.5F, 0.5F);
      as3Back1.setTextureSize(64, 32);
      as3Back1.mirror = true;
      setRotation(as3Back1, 0F, 0F, 0F);
      as1Front2 = new ModelRenderer(this, 9, 18);
      as1Front2.addBox(-0.5F, -2.5F, -2.5F, 1, 5, 1);
      as1Front2.setRotationPoint(-4.5F, 13.5F, 0.5F);
      as1Front2.setTextureSize(64, 32);
      as1Front2.mirror = true;
      setRotation(as1Front2, 0F, 0F, 0F);
      Glider = new ModelRenderer(this, 0, 9);
      Glider.addBox(-6F, 1F, -2.5F, 12, 0, 2);
      Glider.setRotationPoint(0F, 13.5F, 7F);
      Glider.setTextureSize(64, 32);
      Glider.mirror = true;
      setRotation(Glider, -0.7853982F, 0F, 0F);
      OreBar = new ModelRenderer(this, 0, 9);
      OreBar.addBox(0F, 0F, 0F, 12, 1, 1);
      OreBar.setRotationPoint(-6F, 13.5F, 5F);
      OreBar.setTextureSize(64, 32);
      OreBar.mirror = true;
      setRotation(OreBar, 0F, 0F, 0F);
      BottomPlate2 = new ModelRenderer(this, 12, 51);
      BottomPlate2.addBox(0F, 0F, 0F, 12, 1, 12);
      BottomPlate2.setRotationPoint(-6F, 18F, -6F);
      BottomPlate2.setTextureSize(64, 32);
      BottomPlate2.mirror = true;
      setRotation(BottomPlate2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    SupportBeamTop.render(f5);
    SupportBeamRightBottom.render(f5);
    SupportBeamLeftBottom.render(f5);
    WallRight.render(f5);
    WallLeft.render(f5);
    BottomPlate.render(f5);
    SupportBeamLeftFront.render(f5);
    SupportBeamRightFront.render(f5);
    SupportBeamLeftBack.render(f5);
    SupportBeamRightBack.render(f5);
    BottomPipe.render(f5);
    WaterInput.render(f5);
    PowerInput.render(f5);
    ChunksInput.render(f5);
    MixedOutput.render(f5);
    Geul1.render(f5);
    Geul2.render(f5);
    Geul3.render(f5);
    Geul4.render(f5);
    Geul5.render(f5);
    Geul6.render(f5);
    Geul7.render(f5);
    Geul8.render(f5);
    Geul9.render(f5);
    Geul10.render(f5);
    Geul11.render(f5);
    Geul12.render(f5);
    as.render(f5);
    as4Back3.render(f5);
    as3Back3.render(f5);
    as2Back3.render(f5);
    as4Back2.render(f5);
    as3Back2.render(f5);
    as2Back2.render(f5);
    as1Back3.render(f5);
    as1Back2.render(f5);
    as4Front3.render(f5);
    as3Front3.render(f5);
    as2Front3.render(f5);
    as4Front2.render(f5);
    as3Front2.render(f5);
    as2Front2.render(f5);
    as1Front3.render(f5);
    as1middel.render(f5);
    as2middel.render(f5);
    as3middel.render(f5);
    as4middel.render(f5);
    as1Back1.render(f5);
    as1Front1.render(f5);
    as2Front1.render(f5);
    as3Front1.render(f5);
    as4Front1.render(f5);
    as2Back1.render(f5);
    as4Back1.render(f5);
    as3Back1.render(f5);
    as1Front2.render(f5);
    Glider.render(f5);
    OreBar.render(f5);
    BottomPlate2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5);
  }

}
