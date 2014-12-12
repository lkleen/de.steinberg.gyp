{
	'variables': {
		'sequencer_sources_mac': [
			
		],
		'sequencer_sources_win': [
			'<(ROOT)/test1',
			'<(ROOT)/test2',
		],
		'sequencer_sources': [
			'<@(sequencer_sources_mac)',
			'<@(sequencer_sources_win)',
			'test',
			'<(ROOT)test',
		],
		'cubase_common_sources' : [
			'<@(sequencer_sources)',
			'test',
			'<(ROOT)test',
		],
		'cubase-hard_sources' : [
			'<@(cubase_common_sources)',
			'test',
			'<(ROOT)test',
		],
		'cubase-soft_sources' : [
			'<@(cubase_common_sources)',
			'test',
			'<(ROOT)test',
		],
		'nuendo_sources_mac': [
			'<@(sequencer_sources_mac)',
		],
		'nuendo_sources_win': [
			'<@(sequencer_sources_win)',
		],
		'nuendo_sources' : [
			'<@(sequencer_sources)',
			'<@(nuendo_sources_mac)',
			'<@(nuendo_sources_win)',
			'test',
			'<(ROOT)test',
		],
		'sequencer_test_souces': [
			'<@(nuendo_sources)',
			'test',
			'<(ROOT)test',
		],
	},
}