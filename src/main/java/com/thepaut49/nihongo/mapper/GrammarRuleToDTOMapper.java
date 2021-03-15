package com.thepaut49.nihongo.mapper;

import com.thepaut49.nihongo.dto.GrammarRuleDTO;
import com.thepaut49.nihongo.model.GrammarRule;

public class GrammarRuleToDTOMapper {
	
	public static GrammarRuleDTO map(GrammarRule grammarRule) {
		GrammarRuleDTO grammarRuleDTO = new GrammarRuleDTO();
		grammarRuleDTO.setId(grammarRule.getId());
		grammarRuleDTO.setTitle(grammarRule.getTitle());
		grammarRuleDTO.setHtmlDescription(grammarRule.getHtmlDescription());
		grammarRuleDTO.setFirstKeyWord(grammarRule.getFirstKeyWord());
		grammarRuleDTO.setSecondKeyWord(grammarRule.getSecondKeyWord());
		grammarRuleDTO.setThirdKeyWord(grammarRule.getThirdKeyWord());
		grammarRuleDTO.setFourthKeyWord(grammarRule.getFourthKeyWord());
		grammarRuleDTO.setVersion(grammarRule.getVersion());
		return grammarRuleDTO;
	}
	
	public static GrammarRule map(GrammarRuleDTO grammarRuleDTO) {
		GrammarRule grammarRule = new GrammarRule();
		grammarRule.setId(grammarRuleDTO.getId());
		grammarRule.setTitle(grammarRuleDTO.getTitle());
		grammarRule.setHtmlDescription(grammarRuleDTO.getHtmlDescription());
		grammarRule.setFirstKeyWord(grammarRuleDTO.getFirstKeyWord());
		grammarRule.setSecondKeyWord(grammarRuleDTO.getSecondKeyWord());
		grammarRule.setThirdKeyWord(grammarRuleDTO.getThirdKeyWord());
		grammarRule.setFourthKeyWord(grammarRuleDTO.getFourthKeyWord());
		grammarRule.setVersion(grammarRuleDTO.getVersion());
		return grammarRule;
	}

}
