package kr.kosta.coffeeorder.domain;


public class CoffeeType
{
	public final static int COFFEE_SIZE_SMALL = 1;
	public final static int COFFEE_SIZE_MEDIUM = 2;
	public final static int COFFEE_SIZE_LARGE = 3;
	public final static int COFFEE_SHOT_NONE = 1;
	public final static int COFFEE_SHOT_ONE = 2;
	public final static int COFFEE_SHOT_TWO = 3;
	public final static int COFFEE_WHEEPING_NONE = 1;
	public final static int COFFEE_WHEEPING_AVG = 2;
	public final static int COFFEE_WHEEPING_OVER = 3;
	public final static String COFFEE_CUP_MUG = "CUP_MUG";
	public final static String COFFEE_CUP_PLASTIC = "CUP_PLASTIC";
	public final static String COFFEE_CUP_PAPER = "CUP_PAPER";
	public final static String COFFEE_TEMP_HOT = "TEMP_HOT";
	public final static String COFFEE_TEMP_ICE = "TEMP_ICE";
	private static final int COFFEE_SYRUP_NONE = 1;
	private static final int COFFEE_SYRUP_AVG = 2;
	private static final int COFFEE_SYRUP_OVER = 3;
/*
	public int checkSize(int sizeId)
	{
		switch (sizeId)
		{
		case R.id.rdo_custom_small:
			return COFFEE_SIZE_SMALL;
		case R.id.rdo_custom_medium:
			return COFFEE_SIZE_MEDIUM;
		case R.id.rdo_custom_large:
			return COFFEE_SIZE_LARGE;
		default:
			return COFFEE_SIZE_SMALL;
		}
	}

	public int checkShot(int shotId)
	{
		switch (shotId)
		{
		case R.id.rdo_custom_shot1:
			return COFFEE_SHOT_NONE;
		case R.id.rdo_custom_shot2:
			return COFFEE_SHOT_ONE;
		case R.id.rdo_custom_shot3:
			return COFFEE_SHOT_TWO;
		default:
			return COFFEE_SHOT_NONE;
		}
	}

	public String checkTemp(int tempId)
	{
		switch (tempId)
		{
		case R.id.rdo_custom_hot:
			return COFFEE_TEMP_HOT;
		case R.id.rdo_custom_iced:
			return COFFEE_TEMP_ICE;
		default:
			return COFFEE_TEMP_HOT;
		}
	}

	public String checkCup(int cupId)
	{
		switch (cupId)
		{
		case R.id.rdo_custom_mugcup:
			return COFFEE_CUP_MUG;
		case R.id.rdo_custom_plasticcup:
			return COFFEE_CUP_PLASTIC;
		case R.id.rdo_custom_papercup:
			return COFFEE_CUP_PAPER;
		default:
			return COFFEE_CUP_PAPER;
		}
	}

	public int checkWheeping(int wheepingId)
	{
		switch (wheepingId)
		{
		case R.id.rdo_custom_wheeping1:
			return COFFEE_WHEEPING_NONE;
		case R.id.rdo_custom_wheeping2:
			return COFFEE_WHEEPING_AVG;
		case R.id.rdo_custom_wheeping3:
			return COFFEE_WHEEPING_OVER;
		default:
			return COFFEE_WHEEPING_AVG;
		}
	}

	public int checkSyrup(int syrupButtonId)
	{
		switch (syrupButtonId)
		{
		case R.id.rdo_custom_syrup1:
			return COFFEE_SYRUP_NONE;
		case R.id.rdo_custom_syrup2:
			return COFFEE_SYRUP_AVG;
		case R.id.rdo_custom_syrup3:
			return COFFEE_SYRUP_OVER;
		default:
			return COFFEE_SYRUP_NONE;
		}
	}
*/
	public String checkSizeToString(int sizeId)
	{
		switch (sizeId)
		{
		case COFFEE_SIZE_SMALL:
			return "Small";
		case COFFEE_SIZE_MEDIUM:
			return "Medium";
		case COFFEE_SIZE_LARGE:
			return "Large";
		default:
			return "Small";
		}
	}

	public String checkShotToString(int shotId)
	{
		switch (shotId)
		{
		case COFFEE_SHOT_NONE:
			return "샷 없음";
		case COFFEE_SHOT_ONE:
			return "샷 1개";
		case COFFEE_SHOT_TWO:
			return "샷 2개";
		default:
			return "샷 없음";
		}
	}

	public String checkTempToString(String tempId)
	{
		switch (tempId)
		{
		case COFFEE_TEMP_HOT:
			return "Hot";
		case COFFEE_TEMP_ICE:
			return "Iced";
		default:
			return "Hot";
		}
	}

	public String checkCupToString(String cupId)
	{
		switch (cupId)
		{
		case COFFEE_CUP_MUG:
			return "머그컵";
		case COFFEE_CUP_PLASTIC:
			return "플라스틱";
		case COFFEE_CUP_PAPER:
			return "종이";
		default:
			return "종이";
		}
	}

	public String checkWheepingToString(int wheepingId)
	{
		switch (wheepingId)
		{
		case COFFEE_WHEEPING_NONE:
			return "휘핑 없음";
		case COFFEE_WHEEPING_AVG:
			return "휘핑 보통";
		case COFFEE_WHEEPING_OVER:
			return "휘핑 많이";
		default:
			return "휘핑 보통";
		}
	}

	public String checkSyrupToString(int syrupButtonId)
	{
		switch (syrupButtonId)
		{
		case COFFEE_SYRUP_NONE:
			return "시럽 없음";
		case COFFEE_SYRUP_AVG:
			return "시럽 보통";
		case COFFEE_SYRUP_OVER:
			return "시럽 많이";
		default:
			return "시럽 없음";
		}
	}
}
