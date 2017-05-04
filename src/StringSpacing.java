
public class StringSpacing {
	
	void ReplaceSpacing(String string[],int length){
		if(string==null || length<=0){
			return;
		}
		
		//获取新string长度
		int originaLength=0;//实际长度
		int numberOfSpacing=0;
		int i=0;
		while(string[i]!="\0"){
			++ originaLength;
			if (string[i]=="") {
				++numberOfSpacing;
			}
			++i;
		}
		
		int newLength=originaLength+numberOfSpacing*2;
		if (newLength>length) {
			return;
		}
		
		int indexOfOriginal=originaLength;
		int indexOfNew=newLength;
		while (indexOfOriginal>=0 && newLength>indexOfNew) {
			if (string[indexOfOriginal]=="") {
				string[indexOfNew--]="0";
				string[indexOfNew--]="2";
				string[indexOfNew--]="%";
			}else{
				string[indexOfNew--]=string[indexOfOriginal];
			}
			--indexOfOriginal;
		}
	}
}
