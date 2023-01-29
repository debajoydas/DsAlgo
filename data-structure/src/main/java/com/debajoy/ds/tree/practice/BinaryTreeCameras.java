package com.debajoy.ds.tree.practice;

import java.util.concurrent.atomic.AtomicInteger;

public	class BinaryTreeCameras {
	    public int minCameraCover(TreeNode root) {
		    AtomicInteger minCamera = new AtomicInteger();
			return minCameraRequired(root, minCamera, true);
	    }
	    //1.if you need a camera, you are not covered -> 1
		//2. if you have a camera -> 0
		// 3. if you don't need a camera and you are covered -> 2
	  	private static int minCameraRequired(TreeNode node,AtomicInteger minCamera, boolean isRoot){
			if(node == null){
				return 2;
			}
			int condL = minCameraRequired(node.left, minCamera,false);
			int condR = minCameraRequired(node.right, minCamera,false);
			if(!isRoot){
				if(condL == 2 && condR == 2){
					return 1;
				}else if(condL == 1 || condR == 1){
					minCamera.incrementAndGet();
					return 0;
				}else if(condL == 0 || condR == 0){
					return 2;
				}
			}else{
				if(condL == 2 && condR == 2){
					 minCamera.incrementAndGet();
				}else if(condL == 1 || condR == 1){
					minCamera.incrementAndGet();
				}else if(condL == 0 || condR == 0){
					minCamera.get();
				}
			}
			return minCamera.get();
		}
	}
